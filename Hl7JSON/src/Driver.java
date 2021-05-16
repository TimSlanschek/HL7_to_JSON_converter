import java.io.File;

public class Driver {
    /**
     * Demo main method
     *
     * @param args Currently unused
     */
//    public static void main(String[] args) {
//        String directory = "/Users/Destin/OneDrive - Georgia Institute of Tech"
//                + "nology/College/Junior/cs3311-cs3312/project/samples/"
//                + "SampleELRs/";
////        String hl7File = "1Test2774.txt";
////        String jsonFile = "1Test2774.json";
//        String hl7File = "0Test920.txt";
//        String jsonFile = "0Test920.json";
//        HL7Json test = new HL7Json(directory);
//
//        test.convert(hl7File, jsonFile);
//    }

    /**
     * Testing Purposes Only
     *
     * @param args Main method arguments
     */
    public static void main(String[] args) {
        String directory = "/Users/Destin/OneDrive - Georgia Institute of Tech"
                + "nology/College/Junior/cs3311-cs3312/project/samples/"
                + "SampleELRs/";
//        String directory = "/Users/Destin/OneDrive - Georgia Institute of Tech"
//                + "nology/College/Junior/cs3311-cs3312/samples/SampleELR/";
//        String directory = "/Users/Destin/OneDrive - Georgia Institute of Tech"
//                + "nology/College/Junior/cs3311-cs3312/samples/dummy/";

        HL7Json test = new HL7Json(directory);
        File folder =  new File(directory);

        File[] fileList = folder.listFiles();
        if (fileList != null) {
            for (File file: fileList) {
                System.out.println("File Name: " + file.getName());
                String[] fileSplit = file.getName().split("\\.");
                if (fileSplit.length >= 2 && fileSplit[1].equals("txt")) {
                    String fileName = fileSplit[0];
                    String extension = fileSplit[1];
                    if (extension.equals("txt")) {
                        test.convert(fileName);
                    }
                }
            }
        } else {
            test.updateLog("Critical Error: No files found in the directory");
        }

        test.writeToLog();
    }
}
