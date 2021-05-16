import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

import org.json.JSONObject;
import org.json.JSONArray;

public class HL7Json {
    private String directory;

    private JSONObject source;
    private List<String> lines;
    private Map<String, Integer> validity;

    private List<String> log;

    private static final String FIELD_SEPARATOR = "\\|";

    /**
     * Default no-args constructor. Uses the directory that the program is being
     * executed in
     */
    public HL7Json() {
        this("");
    }

    /**
     * Converter Object constructor. Uses the given directory as the source for
     * the input HL7 file and as the destination for the output JSON file
     *
     * @param directory Source for the input HL7 file and destination for the
     *                 output JSON file
     */
    public HL7Json(String directory) {
        this.directory = directory;

        source = new JSONObject();
        lines = new ArrayList<>();
        validity = new HashMap<>();

        log = new ArrayList<>();
    }

    /**
     * Reads the source HL7 file in the top-level directory (specified in the
     * constructor) that has the provided srcName, and converts it to a JSON
     * file that is outputted with the given destName in the same directory.
     *
     * @param fileName the name of the HL7 text file to be converted
     */
    public void convert(String fileName) {
        updateLog("[" + fileName + "]");
        int logSizeInit = log.size();
        parseFile(fileName + ".txt");

//        /* Prints out each Segment:
        System.out.println("HL7 file contains the following segments: ");
        for (int i = 0; i < lines.size() - 1; i++) {
            System.out.print(getSegHeader(lines.get(i)) + ", ");
        }
        System.out.println(getSegHeader(lines.get(lines.size() - 1)));
        System.out.print("\n");
//        */

        JSONObject headerBase = new JSONObject();
        JSONObject header = new JSONObject();

        if (hl7Contains("FHS")) {
            updateLog("Error: Converter does not support batch files\n");
            return;
        } else if (!hl7Contains("MSH")) {
            updateLog("Error: File does not contain MSH segment\n");
            return;
        }

        init(headerBase, header);

        /* Start of Message */
        // Handle Header (MSH, SFT)
        // Cardinality of MSH is [1..1]
        segmentizeMSH(header);
        // Cardinality of SFT is [0..*]
        if (hl7Contains("SFT")) {
            Segment sftHeader = Segment.valueOf("SFT");
            segmentizeSegment(header, sftHeader);
        }

        /* Patient Result */
        JSONObject patientResult = new JSONObject();
        header.put("Patient_Result", patientResult);
        // Handle Patient (PID, NK1) [1..1]
        JSONObject patient = new JSONObject();
        patientResult.put("Patient", patient);
        // Cardinality of PID is [1..1]
        if (!hl7Contains("PID")) {
            updateLog("Error: File does not contain PID segment\n");
            return;
        }
        Segment pidHeader = Segment.valueOf("PID");
        segmentizeSegment(patient, pidHeader);
        // Cardinality of NK1 is [0..*]
        if (hl7Contains("NK1")) {
            Segment nk1Header = Segment.valueOf("NK1");
            segmentizeSegment(patient, nk1Header);
        }

        // Handle Order Observation (OBR, OBX, ORC, SPM, NTE) [1..*]
        JSONArray orderObservation = new JSONArray();
        patientResult.put("Order_Observation", orderObservation);

        List<String> obrList = getSegment("OBR");
//        System.out.println("OBR Size: " + obrList.size() + "\n");

        for (String obrSegment: obrList) {
            JSONObject observationObject = new JSONObject();
            orderObservation.put(observationObject);

            JSONArray observation = new JSONArray();
            observationObject.put("Observation", observation);

            JSONObject obrSegmentObject = new JSONObject();
            segmentize(obrSegmentObject, obrSegment.split(FIELD_SEPARATOR, -1));
            observationObject.put("OBR", obrSegmentObject);

            // Handle ORC [0..1]
            if (getSegHeader(lines.get(lines.indexOf(obrSegment) - 1)).equals("ORC")) {
                String orcSegment = lines.get(lines.indexOf(obrSegment) - 1);

                JSONObject orcSegmentObject = new JSONObject();
                segmentize(orcSegmentObject, orcSegment.split(FIELD_SEPARATOR, -1));
                observationObject.put("ORC", orcSegmentObject);
            }

            List<String> obxList = getObservationList(obrSegment, "OBX", "NTE");
//            System.out.println(obxList.size());

            for (String obxSegment: obxList) {
                JSONObject obxSegmentBase = new JSONObject();
                JSONObject obxSegmentObject = new JSONObject();
                segmentize(obxSegmentObject, obxSegment.split(FIELD_SEPARATOR, -1));
                obxSegmentBase.put("OBX", obxSegmentObject);
                observation.put(obxSegmentBase);

                // Handle NTE [0..*]
                JSONArray nte = new JSONArray();
                List<String> nteList = getObservationList(obxSegment, "NTE", "");
                for (String nteSegment: nteList) {
                    JSONObject nteSegmentBase = new JSONObject();
                    JSONObject nteSegmentObject = new JSONObject();
                    segmentize(nteSegmentObject, nteSegment.split(FIELD_SEPARATOR, -1));
                    nteSegmentBase.put("NTE", nteSegmentObject);
                    nte.put(nteSegmentBase);
                }
                if (nteList.size() > 0) {
                    obxSegmentBase.put("Notes and Comments", nte);
                }
            }

            // Handle SPM [0..1]
            JSONArray spm = new JSONArray();
            List<String> spmList = getObservationList(obxList.get(obxList.size() - 1), "SPM", "NTE");
            for (String spmSegment: spmList) {
                JSONObject spmSegmentBase = new JSONObject();
                JSONObject spmSegmentObject = new JSONObject();
                segmentize(spmSegmentObject, spmSegment.split(FIELD_SEPARATOR, -1));
                spmSegmentBase.put("SPM", spmSegmentObject);
                spm.put(spmSegmentBase);
            }
            if (spmList.size() > 0) {
                observationObject.put("Specimen", spm);
            }
        }

        for (String key: validity.keySet()) {
            if (validity.get(key) != 0) {
                updateLog("Warning: File contains undefined Segment " + key
                        + "; segment ignored in output");
            }
        }

        if (logSizeInit == log.size()) {
            updateLog("File successfully converted with no warnings/errors");
        }
        updateLog("");
        writeToFile(fileName + ".json");
    }

    /**
     * Boilerplate initialization for all HL7 files
     * 
     * @param headerBase JSONObject that pairs "ORU_R01" with header, which is
     *                   the JSONObject that actually holds the whole message.
     *                   HeaderBase only exists because of notation.
     * @param header JSONObject that holds the header segment as described by
     *               the abstract message syntax.
     */
    private void init(JSONObject headerBase, JSONObject header) {
        // Source Message
        source.put("message", headerBase);
        headerBase.put("source", header);
        headerBase.put("type", getSegment("MSH").get(0).split(FIELD_SEPARATOR, -1)[8]);
        headerBase.put("HL7-version", getSegment("MSH").get(0).split(FIELD_SEPARATOR, -1)[11]);
//        headerBase.put("Number of Segments", lines.size());

        // Converter Info
        JSONObject metadata = new JSONObject();
        metadata.put("title", "HL7-to-JSON-converter");
        metadata.put("author", "Destin Winata");
        metadata.put("version", "1.0");
        source.put("converter", metadata);
    }

    /**
     * Base method for all other segmentize methods (excluding segmentizeMSH).
     * Provides the main logic behind breaking down a segment into its
     * respective hierarchy, and then storing it in a JSON object.
     *
     * @param segmentObject the SegmentObject corresponding to the segment that
     *                      is being broken down (used for metadata in the JSON)
     * @param segment String array where each element is a field of the segment
     *                that is being broken down
     */
    private void segmentize(JSONObject segmentObject, String[] segment) {
        Segment segHeader = Segment.valueOf(segment[0]);

        for (int i = 1; i < segment.length; i++) {
            JSONArray fieldRepeat = new JSONArray();
            String[] fields = segment[i].split("~", -1);

            for (String f: fields) {
                String[] field = f.split("\\^", -1);
                JSONObject fieldObject = new JSONObject();

                if (fields.length == 1) {
                    if (field.length == 1) {
                        segmentObject.put(Integer.toString(i), field[0]);
                    } else {
                        segmentObject.put(Integer.toString(i), fieldObject);
                    }
                } else {
                    if (field.length == 1) {
                        fieldRepeat.put(field[0]);
                    } else {
                        fieldRepeat.put(fieldObject);
                    }
                    segmentObject.put(Integer.toString(i), fieldRepeat);
                }

                for (int j = 0; j < field.length; j++) {
                    String[] component = field[j].split("&", -1);
                    JSONObject componentObject = new JSONObject();

                    if (component.length == 1) {
                        fieldObject.put(Integer.toString(j + 1), component[0]);
                    } else {
                        fieldObject.put(Integer.toString(j + 1), componentObject);
                    }

                    for (int k = 0; k < component.length; k++) {
                        componentObject.put(Integer.toString(k + 1), component[k]);
                    }
                }
            }
        }

        validity.put(segment[0], validity.get(segment[0]) - 1);
    }

    /**
     * Breaks down String object containing the segment into its respective
     * hierarchy, and then stores it in the JSON head object.
     *
     * @param head The head JSON object to append to. Note: superclass of
     *             JSONObject and JSONArray is Object (there is no hierarchy in
     *             between, which is why the declared type is Object)
     * @param segHeader The HL7 segment to be converted
     */
    private void segmentizeSegment(JSONObject head, Segment segHeader) {
        List<String> segments = getSegment(segHeader.name());

        for (String s: segments) {
            JSONObject segmentObject = new JSONObject();
            String[] segment = s.split(FIELD_SEPARATOR, -1);

            head.put(segment[0], segmentObject);

            segmentize(segmentObject, segment);
        }
    }

    /**
     * Breaks down String object containing the Message Header segment into its
     * respective hierarchy, and then stores it in the JSON head object.
     * Note: Cardinality of MSH segment is [1..1], meaning the segment is
     * mandatory and it only occurs once.
     *
     * @param head The head JSONObject to append to.
     */
    private void segmentizeMSH(JSONObject head) {
        Segment mshHeader = Segment.MSH;

        if (getSegment("MSH").size() == 0) {
            return;
        }

        String[] mshSegment = getSegment("MSH").get(0).split(FIELD_SEPARATOR, -1);
        JSONObject mshSegmentObject = new JSONObject();

        head.put(mshSegment[0], mshSegmentObject);

        mshSegmentObject.put(mshSegment[0] + "-1", "|");
        for (int i = 1; i < mshSegment.length; i++) {
            String[] mshField = mshSegment[i].split("\\^", -1);
            JSONObject mshFieldObject = new JSONObject();

            // Encoding Characters exception
            if (i == 1) {
                mshField = new String[1];
                mshField[0] = mshSegment[i];
            }

            if (mshField.length == 1) {
                mshSegmentObject.put(Integer.toString(i + 1), mshField[0]);
            } else {
                mshSegmentObject.put(Integer.toString(i + 1), mshFieldObject);
            }

            for (int j = 0; j < mshField.length ; j++) {
                String[] component = mshField[j].split("&", -1);
                JSONObject componentObject = new JSONObject();

                if (component.length == 1) {
                    mshFieldObject.put(Integer.toString(j + 1), component[0]);
                } else {
                    mshFieldObject.put(Integer.toString(j + 1), componentObject);
                }

                for (int k = 0; k < component.length; k++) {
                    componentObject.put(Integer.toString(k + 1), component[k]);
                }
            }
        }

        validity.put("MSH", validity.get("MSH") - 1);
    }

    /**
     * Divides the input HL7 file into a list of Strings, where each String is a
     * segment of the message.
     *
     * @param srcName Name of input HL7 file
     */
    private void parseFile(String srcName) {
        File file = new File(directory + srcName);
        lines.clear();
        validity.clear();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            for (String s = reader.readLine(); s != null;) {
                String[] fields = s.split(FIELD_SEPARATOR, -1);
                String header = fields[0];
                lines.add(s);
                if (!validity.containsKey(header)) {
                    validity.put(header, 1);
                } else {
                    validity.put(header, validity.get(header) + 1);
                }

                s = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Converts the JSON base object to a String, writes that to a FileWriter
     * object, which will create an output JSON file with the given destName.
     *
     * @param destName Name of output JSON file
     */
    private void writeToFile(String destName) {
        try {
            File output = new File(directory + "output/");
            output.mkdir();
            FileWriter writer = new FileWriter(directory + "output/" + destName);

            writer.write(source.toString(2));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateLog(String message) {
        log.add(message);
    }

    public void writeToLog() {
        try {
            FileWriter writer = new FileWriter(directory + "output/" + "log.txt");

            for (String message: log) {
                writer.write(message + "\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Returns lists of relevant target segments, using a base inputted segment
     * as a starting point in the message. Will also avoid the NTE comment
     * segment, unless the target is NTE. Used only for the observation portion.
     * More specifically:
     * When target = "OBX", base = "OBR", ignore = "NTE",
     * When target = "NTE", base = "OBX", ignore = "",
     * When target = "SPM", base = "OBX", ignore = "NTE".
     *
     * @param base Where to start reading from in the HL7 message
     * @param target Segment To add to the list
     * @param ignore Segment To not add to the list
     * @return
     */
    private List<String> getObservationList(String base, String target, String ignore) {
        List<String> observationList = new ArrayList<>();
        int targetStartIndex = lines.indexOf(base) + 1;

        if (targetStartIndex <= 0 || targetStartIndex >= lines.size()) {
            return observationList;
        }

        String[] fields = lines.get(targetStartIndex).split(FIELD_SEPARATOR, -1);
        for (int i = targetStartIndex; i < lines.size()
                && (fields[0].equals(target) || fields[0].equals(ignore)); i++) {
            if (fields[0].equals(target)) {
                observationList.add(lines.get(i));
            }
            if (i < lines.size() - 1) {
                fields = lines.get(i + 1).split(FIELD_SEPARATOR, -1);
            }
        }

        return observationList;
    }

    /**
     * Returns all instances of a segment
     *
     * @param segHeader the segment header to search for
     * @return list of all instances of a segment in the message
     */
    private List<String> getSegment(String segHeader) {
        List<String> temp = new ArrayList<>();
        for (String s: lines) {
            if (getSegHeader(s).equalsIgnoreCase(segHeader)) {
                temp.add(s);
            }
        }

        return temp;
    }

    /**
     * Returns the header of the given segment
     *
     * @param segment the given HL7 message segment
     * @return segment header
     */
    private String getSegHeader(String segment) {
        return segment.split(FIELD_SEPARATOR)[0];
    }

    /**
     * Returns true if the hl7 file contains the given segment, false otherwise
     *
     * @param target the target segment
     * @return true if file contains the segment, false otherwise
     */
    private boolean hl7Contains(String target) {
        for (String s: lines) {
            if (getSegHeader(s).equalsIgnoreCase(target)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Prints all segments of the HL7 file (in their entirety). Used for
     * debugging purposes only.
     */
    private void printSegments() {
        for (String s: lines) {
            System.out.println(s);
        }
    }

    /**
     * Returns JSONObject body (the entire JSON file encapsulated in an object.
     * Used for testing purposes only.
     *
     * @return body The body of the JSON object
     */
    public JSONObject getHl7() {
        return source;
    }
}
