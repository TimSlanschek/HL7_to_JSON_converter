import java.util.HashMap;
import java.util.Map;

public enum Segment {
    MSH(Map.ofEntries( //components
            Map.entry("3", new String[] {"IS", "ST", "ID"}),
            Map.entry("4", new String[] {"IS", "ST", "ID"}),
            Map.entry("5", new String[] {"IS", "ST", "ID"}),
            Map.entry("6", new String[] {"IS", "ST", "ID"}),
            Map.entry("7", new String[] {"DTM", "ID"}),
            Map.entry("9", new String[] {"ID", "ID", "ID"}),
            Map.entry("11", new String[] {"ID", "ID"}),
            Map.entry("12", new String[] {"ID", "CE", "CE"}),
            Map.entry("21", new String[] {"ST", "IS", "ST", "ID"})
    ), new String[] { //fieldDescriptions
            "Field Separator",
            "Encoding Characters",
            "Sending Application",
            "Sending Facility",
            "Receiving Application",
            "Receiving Facility",
            "Date/Time of Message",
            "Security",
            "Message Type",
            "Message Control ID",
            "Processing ID",
            "Version ID",
            "Sequence Number",
            "Continuation Pointer",
            "Accept Acknowledgment Type",
            "Application Acknowledgment Type",
            "Country Code",
            "Character Set",
            "Principal Language Of Message",
            "Alternate Character Set Handling Scheme",
            "Message Profile Identifier"
    },
            //fields
            "ST", "ST", "HD", "HD", "HD", "HD", "TS", "ST", "MSG", "ST", "PT",
            "VID", "NM", "ST", "ID", "ID", "ID", "ID", "CE", "ID", "EI"),

    SFT(Map.ofEntries( //components
            Map.entry("1", new String[] {"ST", "IS", "NM", "NM", "ID", "HD", "ID", "HD", "ID", "ST"}),
            Map.entry("6", new String[] {"DTM", "ID"})
    ), new String[]{ //fieldDescriptions
            "Software Vendor Organization",
            "Software Certified Version or Release Number",
            "Software Product Name",
            "Software Binary ID",
            "Software Product Information",
            "Software Install Date"
    }, //fields
            "XON", "ST", "ST", "ST", "TX", "TS"),

    PID(Map.ofEntries( //components
            Map.entry("3", new String[] {"ST", "ST", "ID", "HD", "ID", "HD", "TS", "TS", "CWE", "CWE"}),
            Map.entry("5", new String[] {"FN", "ST", "ST", "ST", "ST",
                    "ID", "ID", "CE", "DR", "ID", "TS", "TS", "ST"}),
            Map.entry("6", new String[] {"FN", "ST", "ST", "ST", "ST", "IS",
                    "ID", "ID", "CE", "DR", "ID", "TS", "TS", "ST"}),
            Map.entry("7", new String[] {"DTM", "ID", "ST"}),
            Map.entry("10", new String[] {"ST", "ST", "ID", "ST", "ST", "ID"}),
            Map.entry("11", new String[] {"SAD", "ST", "ST", "ST", "ST", "ID", "ID", "ST",
                    "IS", "IS", "ID", "DR", "TS", "TS"}),
            Map.entry("13", new String[] {"ST", "ID", "ID", "ST", "NM", "NM", "NM", "NM",
                    "ST", "ST", "ST", "ST"}),
            Map.entry("14", new String[] {"ST", "ID", "ID", "ST", "NM", "NM", "NM", "NM",
                    "ST", "ST", "ST", "ST"}),
            Map.entry("15", new String[] {"ST", "ST", "ID", "ST", "ST", "ID"}),
            Map.entry("16", new String[] {"ST", "ST", "ID", "ST", "ST", "ID"}),
            Map.entry("18", new String[] {"ST", "ST", "ID", "HD", "ID", "HD", "TS", "TS", "CWE", "CWE"}),
            Map.entry("21", new String[] {"ST", "ST", "ID", "HD", "ID", "HD", "TS", "TS", "CWE", "CWE"}),
            Map.entry("22", new String[] {"ST", "ST", "ID", "ST", "ST", "ID"}),
            Map.entry("26", new String[] {"ST", "ST", "ID", "ST", "ST", "ID"}),
            Map.entry("29", new String[] {"DTM", "ID"}),
            Map.entry("33", new String[] {"DTM", "ID"}),
            Map.entry("34", new String[] {"IS","ST", "ID"}),
            Map.entry("35", new String[] {"ST", "ST", "ID", "ST", "ST", "ID"}),
            Map.entry("36", new String[] {"ST", "ST", "ID", "ST", "ST", "ID"}),
            Map.entry("38", new String[] {"ST", "ST", "ID", "ST", "ST", "ID"})

    ), Map.ofEntries( //subcomponents
            Map.entry("3.4", new String[] {"IS", "ST", "ID"}),
            Map.entry("3.6", new String[] {"IS", "ST", "ID"}),
            Map.entry("3.9", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("3.10", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("5.1", new String[] {"ST", "ST", "ST", "ST", "ST"}),
            Map.entry("6.1", new String[] {"ST", "ST", "ST", "ST", "ST"}),
            Map.entry("11.1", new String[] {"ST", "ST", "ST"}),
            Map.entry("18.4", new String[] {"IS", "ST", "ID"}),
            Map.entry("18.6", new String[] {"IS", "ST", "ID"}),
            Map.entry("18.9", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("18.10", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("21.4", new String[] {"IS", "ST", "ID"}),
            Map.entry("21.6", new String[] {"IS", "ST", "ID"}),
            Map.entry("21.9", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("21.10", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"})
    ), new String[]{ //fieldDescriptions
            "Set ID - PID",
            "Patient ID",
            "Patient Identifier List",
            "Alternate Patient ID - PID",
            "Patient Name",
            "Mother's Maiden Name",
            "Date/Time of Birth",
            "Administrative Sex",
            "Patient Alias",
            "Race",
            "Patient Address",
            "County Code",
            "Phone Number - Home",
            "Phone Number - Business",
            "Primary Language",
            "Marital Status",
            "Religion",
            "Patient Account Number",
            "SSN Number - Patient",
            "Driver's License Number - Patient",
            "Mother's Identifier",
            "Ethnic Group",
            "Birth Place",
            "Multiple Birth Indicator",
            "Birth Order",
            "Citizenship",
            "Veterans Military Status",
            "Nationality",
            "Patient Death Date and Time",
            "Patient Death Indicator",
            "Identity Unknown Indicator",
            "Identity Reliability Code",
            "Last Update Date/Time",
            "Last Update Facility",
            "Species Code",
            "Breed Code",
            "Strain",
            "Production Class Code",
            "Tribal Citizenship"
    }, //fields
            "SI", "CX", "CX", "CX", "XPN", "XPN", "TS", "IS", "XPN", "CE",
            "XAD", "IS", "XTN", "", "CE", "CE", "CE", "CX", "ST", "DLN",
            "CX", "CE", "ST", "ID", "NM", "CE", "CE", "CE", "TS", "ID",
            "ID", "IS", "TS", "HD", "CE", "CE", "ST", "CE", "CWE"),
    NK1(Map.ofEntries( //components
            Map.entry("2", new String[] {"FN", "ST", "ST", "ST", "ST", "IS", "ID", "ID", "CE", "DR", "ID", "TS", "TS", "ST"}),
            Map.entry("3", new String[] {"ST", "ST", "ID", "ST", "ST", "ID"}),
            Map.entry("4", new String[] {"SAD", "ST", "ST", "ST", "ST", "ID", "ID", "ST", "IS", "IS", "ID", "DR", "TS", "TS"}),
            Map.entry("5", new String[] {"ST", "ID", "ID", "ST", "NM", "NM", "NM", "NM", "ST", "ST", "ST", "ST"}),
            Map.entry("6", new String[] {"ST", "ID", "ID", "ST", "NM", "NM", "NM", "NM", "ST", "ST", "ST", "ST"}),
            Map.entry("7", new String[] {"ST", "ST", "ID", "ST", "ST", "ID"}),
            Map.entry("11", new String[] {"IS", "IS", "TX"}),
            Map.entry("13", new String[] {"ST", "IS", "NM", "NM", "ID", "HD", "ID", "HD", "ID", "ST"}),
            Map.entry("20", new String[] {"ST", "ST", "ID", "ST", "ST", "ID"}),
            Map.entry("30", new String[] {"FN", "ST", "ST", "ST", "ST", "IS", "ID", "ID", "CE", "DR", "ID", "TS", "TS", "ST"}),
            Map.entry("31", new String[] {"ST", "ID", "ID", "ST", "NM", "NM", "NM", "NM", "ST", "ST", "ST", "ST"}),
            Map.entry("32", new String[] {"SAD", "ST", "ST", "ST", "ST", "ID", "ID", "ST", "IS", "IS", "ID", "DR", "TS", "TS"})

    ), Map.ofEntries( //subcomponents
            Map.entry("2.1", new String[] {"ST", "ST", "ST", "ST", "ST"}),
            Map.entry("4.1", new String[] {"ST", "ST", "ST"}),
            Map.entry("30.1", new String[] {"ST", "ST", "ST", "ST", "ST"}),
            Map.entry("32.1", new String[] {"ST", "ST", "ST"})
    ), new String[]{ //fieldDescriptions
            "Set ID - NK1",
            "Name",
            "Relationship",
            "Address",
            "Phone Number",
            "Business Phone Number",
            "Contact Role",
            "Start Date",
            "End Date",
            "Next of Kin / Associated Parties Job Title",
            "Next of Kin / Associated Parties Job Code/Class",
            "Next of Kin / Associated Parties Employee Number",
            "Organization Name - NK1",
            "Marital Status",
            "Administrative Sex",
            "Date/Time of Birth",
            "Living Dependency",
            "Ambulatory Status",
            "Citizenship",
            "Primary Language",
            "Living Arrangement",
            "Publicity Code",
            "Protection Indicator",
            "Student Indicator",
            "Religion",
            "Mother's Maiden Name",
            "Nationality",
            "Ethnic Group",
            "Contact Reason",
            "Contact Person's Name",
            "Contact Person's Telephone Number",
            "Contact Person's Address",
            "Next of Kin / Associated Party's Identifiers",
            "Job Status",
            "Race",
            "Handicap",
            "Contact Person social Security Number",
            "Next of Kin Birth Place",
            "VIP Indicator"
    }, //fields
            "SI", "XPN", "CE", "XAD", "XTN", "XTN", "CE", "DT", "DT", "ST",
            "JCC", "CX", "XON", "CE", "IS", "TS", "IS", "IS", "CE", "CE",
            "IS", "CE", "ID", "IS", "CE", "XPN", "CE", "CE", "CE", "XPN",
            "XTN", "XAD", "CX", "IS", "CE", "IS", "ST", "ST", "IS"),
    ORC(Map.ofEntries( //components
            Map.entry("2", new String[] {"ST", "IS", "ST", "ID"}),
            Map.entry("3", new String[] {"ST", "IS", "ST", "ID"}),
            Map.entry("12", new String[] {"ST", "FN", "ST", "ST", "ST", "ST", "IS", "IS", "HD", "IS", "ST", "ID", "ID",
                    "ST", "ID", "HD", "ID", "CE", "DR", "ID", "TS", "TS", "ST", "CWE", "CWE"}),
            Map.entry("21", new String[] {"ST", "IS", "NM", "NM", "ID", "HD", "ID", "HD", "ID", "ST"}),
            Map.entry("22", new String[] {"SAD", "ST", "ST", "ST", "ST", "ID", "ID", "ST", "IS", "IS", "ID", "DR", "TS", "TS"}),
            Map.entry("23", new String[] {"ST", "ID", "ID", "ST", "NM", "NM", "NM", "NM", "ST", "ST", "ST", "ST"}),
            Map.entry("24", new String[] {"SAD", "ST", "ST", "ST", "ST", "ID", "ID", "ST", "IS", "IS", "ID", "DR", "TS", "TS"})

    ), Map.ofEntries( //subcomponents
            Map.entry("12.2", new String[] {"ST", "ST", "ST", "ST", "ST"}),
            Map.entry("12.9", new String[] {"IS", "ST", "ID"}),
            Map.entry("12.22", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("12.23", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("22.1", new String[] {"ST", "ST", "ST"}),
            Map.entry("24.1", new String[] {"ST", "ST", "ST"})
    ), new String[]{ //fieldDescriptions
            "Order Control",
            "Placer Order Number",
            "Filler Order Number",
            "Placer Group Number",
            "Order Status",
            "Response Flag",
            "Quantity/Timing",
            "Parent",
            "Date/Time of Transaction",
            "Entered By",
            "Verified By",
            "Ordering Provider",
            "Enterer's Location",
            "Call Back Phone Number",
            "Order Effective Date/Time",
            "Order Control Code Reason",
            "Entering Organization",
            "Entering Device",
            "Action By",
            "Advanced Beneficiary Notice Code",
            "Ordering Facility Name",
            "Ordering Facility Address",
            "Ordering Facility Phone Number",
            "Ordering Provider Address",
            "Order Status Modifier",
            "Advanced Beneficiary Notice Override Reason",
            "Filler's Expected Availability Date/Time",
            "Confidentiality Code",
            "Order Type",
            "Enterer Authorization Mode"
    }, //fields
            "ID", "EI", "EI", "EI", "ID", "ID", "TQ", "EIP", "TS", "XCN",
            "XCN", "XCN", "PL", "XTN", "TS", "CE", "CE", "CE", "XCN", "CE",
            "XON", "XAD", "XTN", "XAD", "CWE", "CWE", "TS", "CWE", "CWE", "CNE"),
    OBR(Map.ofEntries( //components
            Map.entry("2", new String[] {"ST", "IS", "ST", "ID"}),
            Map.entry("3", new String[] {"ST", "IS", "ST", "ID"}),
            Map.entry("4", new String[] {"ST", "ST", "ID", "ST", "ST", "ID"}),
            Map.entry("6", new String[] {"DTM", "ID"}),
            Map.entry("7", new String[] {"DTM", "ID"}),
            Map.entry("8", new String[] {"DTM", "ID"}),
            Map.entry("10", new String[] {"ST", "FN", "ST", "ST", "ST", "ST", "IS", "IS", "HD", "ID", "ST",
                    "ID", "ID", "HD", "ID", "CE", "DR", "ID", "TS", "TS", "ST", "CWE", "CWE"}),
            Map.entry("16", new String[] {"ST", "FN", "ST", "ST", "ST", "ST", "IS", "IS", "HD", "ID", "ST",
                    "ID", "ID", "HD", "ID", "CE", "DR", "ID", "TS", "TS", "ST", "CWE", "CWE"}),
            Map.entry("17", new String[] {"ST", "ID", "ID", "ST", "NM", "NM", "NM", "NM", "ST", "ST", "ST", "ST"}),
            Map.entry("22", new String[] {"DTM", "ID"}),
            Map.entry("26", new String[] {"CE", "ST", "ST", "ID", "ST", "ST", "ID", "ST", "TX"}),
            Map.entry("28", new String[] {"ST", "FN", "ST", "ST", "ST", "ST", "IS", "IS", "HD", "ID", "ST",
                    "ID", "ID", "HD", "ID", "CE", "DR", "ID", "TS", "TS", "ST", "CWE", "CWE"}),
            Map.entry("29", new String[] {"EI", "EI"}),
            Map.entry("31", new String[] {"ST", "ST", "ID", "ST", "ST", "ID"}),
            Map.entry("32", new String[] {"CNN", "TS", "TS", "IS", "IS", "IS", "HD", "IS", "IS", "IS", "IS"}),
            Map.entry("33", new String[] {"CNN", "TS", "TS", "IS", "IS", "IS", "HD", "IS", "IS", "IS", "IS"}),
            Map.entry("34", new String[] {"CNN", "TS", "TS", "IS", "IS", "IS", "HD", "IS", "IS", "IS", "IS"}),
            Map.entry("35", new String[] {"CNN", "TS", "TS", "IS", "IS", "IS", "HD", "IS", "IS", "IS", "IS"}),
            Map.entry("36", new String[] {"DTM", "ID"}),
            Map.entry("39", new String[] {"ST", "ST", "ID", "ST", "ST", "ID"})

    ), Map.ofEntries( //subcomponents
            Map.entry("10.2", new String[] {"ST", "ST", "ST", "ST", "ST"}),
            Map.entry("10.9", new String[] {"IS", "ST", "ID"}),
            Map.entry("10.22", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("10.23", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("16.2", new String[] {"ST", "ST", "ST", "ST", "ST"}),
            Map.entry("16.9", new String[] {"IS", "ST", "ID"}),
            Map.entry("16.22", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("16.23", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("26.1", new String[] {"ST", "ST", "ID", "ST", "ST", "ID"}),
            Map.entry("28.2", new String[] {"ST", "ST", "ST", "ST", "ST"}),
            Map.entry("28.9", new String[] {"IS", "ST", "ID"}),
            Map.entry("28.22", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("28.23", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("29.1", new String[] {"ST", "IS", "ST", "ID"}),
            Map.entry("29.2", new String[] {"ST", "IS", "ST", "ID"}),
            Map.entry("32.1", new String[] {"ST", "ST", "ST", "ST", "ST", "ST", "IS", "IS", "IS", "ST", "ID"}),
            Map.entry("33.1", new String[] {"ST", "ST", "ST", "ST", "ST", "ST", "IS", "IS", "IS", "ST", "ID"}),
            Map.entry("34.1", new String[] {"ST", "ST", "ST", "ST", "ST", "ST", "IS", "IS", "IS", "ST", "ID"}),
            Map.entry("35.1", new String[] {"ST", "ST", "ST", "ST", "ST", "ST", "IS", "IS", "IS", "ST", "ID"})
    ), new String[]{ //fieldDescriptions
            "Set ID - OBR",
            "Placer Order Number",
            "Filler Order Number",
            "Universal Service Identifier",
            "Priority - OBR",
            "Requested Date/Time",
            "Observation Date/Time",
            "Observation end Date/Time",
            "Collection Volume",
            "Collector Identifier",
            "Specimen Action Code",
            "Danger Code",
            "Relevant Clinical Information",
            "Specimen Received Date/Time",
            "Specimen Source",
            "Ordering Provider",
            "Oder Callback Phone Number",
            "Placer Field 1",
            "Placer Field 2",
            "Filler Field 1",
            "Filler Field 2",
            "Results Rpt/Status Chng - Date/Time",
            "Charge to Practice",
            "Diagnostic Serv Sect ID",
            "Result Status",
            "Parent Result",
            "Quantity/Timing",
            "Result Copies To",
            "Parent",
            "Transportation Mode",
            "Reason for Study",
            "Principal Result Interpreter",
            "Assistant Result Interpreter",
            "Technician",
            "Transcriptionist",
            "Scheduled Date/Time",
            "Number of Sample Containers",
            "Transport Logistics of Collected Sample",
            "Collector's Comment",
            "Transport Arrangement Responsibility",
            "Transport Arranged",
            "Escort Required",
            "Planned Patient Transport Comment",
            "Procedure Code",
            "Procedure Code Modifier",
            "Placer Supplemental Service Information",
            "Filler Supplemental Service Information",
            "Medically Necessary Duplicate Procedure Reason",
            "Result Handling"
    }, //fields
            "SI", "EI", "EI", "CE", "ID", "TS", "TS", "TS", "CQ", "XCN",
            "ID", "CE", "ST", "TS", "SPS", "XCN", "XTN", "ST", "ST", "ST",
            "ST", "TS", "MOC", "ID", "ID", "PRL", "TQ", "XCN", "EIP", "ID",
            "CE", "NDL", "NDL", "NDL", "NDL", "TS", "NM", "CE", "CE", "CE",
            "ID", "ID", "CE", "CE", "CE", "CE", "CE", "CWE", "IS"),
    OBX(Map.ofEntries( //components
            Map.entry("3", new String[] {"ST", "ST", "ID", "ST", "ST", "ID"}),
            Map.entry("5-0", new String[] {}), //these do not have components
            Map.entry("5-1", new String[] {}), //but included them because the others are #2 and 3
            Map.entry("5-2", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("5-3", new String[] {"ST", "NM", "ST", "NM"}),
            Map.entry("6", new String[] {"ST", "ST", "ID", "ST", "ST", "ID"}),
            Map.entry("15", new String[] {"ST", "ST", "ID", "ST", "ST", "ID"}),
            Map.entry("16", new String[] {"ST", "FN", "ST", "ST", "ST", "ST", "IS", "IS", "HD", "ID", "ST",
                    "ID", "ID", "HD", "ID", "CE", "DR", "ID", "TS", "TS", "ST", "CWE", "CWE"}),
            Map.entry("17", new String[] {"ST", "ST", "ID", "ST", "ST", "ID"}),
            Map.entry("18", new String[] {"ST", "IS", "ST", "ID"}),
            Map.entry("19", new String[] {"DTM", "ID"})

    ), Map.ofEntries( //subcomponents
            Map.entry("16.2", new String[] {"ST", "ST", "ST", "ST", "ST"}),
            Map.entry("16.9", new String[] {"IS", "ST", "ID"}),
            Map.entry("16.22", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("16.23", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"})
    ), new String[]{ //fieldDescriptions
            "Set ID - OBX",
            "Value Type",
            "Observation Identifier",
            "Observation Sub-ID",
            "Observation Value",
            "Units",
            "References Range",
            "Abnormal Flags",
            "Probability",
            "Nature of Abnormal Test",
            "Observation Result Status",
            "Effective Date of Reference Range",
            "User-Defined Access Checks",
            "Date/Time of the Observation",
            "Producer's ID",
            "Responsible Observer",
            "Observation Method",
            "Equipment Instance Identifier",
            "Date/Time of the Analysis",
            "Reserved for harmonization with V2.6",
            "Reserved for harmonization with V2.6",
            "Reserved for harmonization with V2.6",
            "Performing Organization Name",
            "Performing Organization Address",
            "Performing Organization Medical Director"
    }, //fields
            "SI", "ID", "CE", "ST", "Var", "CE", "ST", "IS", "NM", "ID",
            "ID", "TS", "ST", "TS", "CE", "XCN", "CE", "EI", "TS", "",
            "", "", "XON", "XAD", "XCN"),

    NTE(Map.ofEntries( //components
            Map.entry("4", new String[] {"ST", "ST", "ID", "ST", "ST", "ID"})
    ), new String[]{ //fieldDescriptions
            "Set ID - NTE",
            "Source of Comment",
            "Comment",
            "Comment Type"
    }, //fields
            "SI", "ID", "FT", "CE"),

    SPM(Map.ofEntries( //components
            Map.entry("2", new String[] {"EI", "EI"}),
            Map.entry("3", new String[] {"EI", "EI"}),
            Map.entry("4", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("5", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("6", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("7", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("8", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("9", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("10", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("11", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("12", new String[] {"NM", "CE"}),
            Map.entry("15", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("16", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("17", new String[] {"TS", "TS"}),
            Map.entry("18", new String[] {"DTM", "ID"}),
            Map.entry("19", new String[] {"DTM", "ID"}),
            Map.entry("21", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("22", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("23", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("24", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("25", new String[] {"NM", "CE"}),
            Map.entry("27", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("28", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"}),
            Map.entry("29", new String[] {"ST", "ST", "ID", "ST", "ST", "ID", "ST", "ST", "ST"})

    ), Map.ofEntries( //subcomponents
            Map.entry("2.1", new String[] {"ST", "IS", "ST", "ID"}),
            Map.entry("2.2", new String[] {"ST", "IS", "ST", "ID"}),
            Map.entry("3.1", new String[] {"ST", "IS", "ST", "ID"}),
            Map.entry("3.2", new String[] {"ST", "IS", "ST", "ID"}),
            Map.entry("12.2", new String[] {"ST", "ST", "ID", "ST", "ST", "ID"}),
            Map.entry("17.1", new String[] {"DTM", "ID"}),
            Map.entry("17.2", new String[] {"DTM", "ID"}),
            Map.entry("25.2", new String[] {"ST", "ST", "ID", "ST", "ST", "ID"})
    ), new String[]{ //fieldDescriptions
            "Set ID - SPM",
            "Specimen ID",
            "Specimen Parent IDs",
            "Specimen Type",
            "Specimen Type Modifier",
            "Specimen Additives",
            "Specimen Collection Method",
            "Specimen Source Site",
            "Specimen Source Site Modifier",
            "Specimen Collection Site",
            "Specimen Role",
            "Specimen Collection Amount",
            "Grouped Specimen Count",
            "Specimen Description",
            "Specimen Handling Code",
            "Specimen Risk Code",
            "Specimen Collection Date/Time",
            "Specimen Received Date/Time",
            "Specimen Expiration Date/Time",
            "Specimen Availability",
            "Specimen Reject Reason",
            "Specimen Quality",
            "Specimen Appropriateness",
            "Specimen Condition",
            "Specimen Current Quantity",
            "Number of Specimen Containers",
            "Container Type",
            "Container Condition",
            "Specimen Child Role"
    }, //fields
            "SI", "EIP", "EIP", "CWE", "CWE", "CWE", "CWE", "CWE", "CWE", "CWE",
            "CWE", "CQ", "NM", "ST", "CWE", "CWE", "DR", "TS", "TS", "ID",
            "CWE", "CWE", "CWE", "CWE", "CQ", "NM", "CWE", "CWE", "CWE");

    private String[] fieldLabels;
    private Map<String, String[]> componentLabels;
    private Map<String, String[]> subComponentLabels;
    private String[] fieldDescriptions;

    /**
     * Constructor for Segments with subcomponents
     * @param componentLabels
     * @param subComponentLabels
     * @param fieldDescriptions
     * @param fieldLabels
     */
    Segment(Map<String, String[]> componentLabels,
            Map<String, String[]> subComponentLabels,
            String[] fieldDescriptions,
            String... fieldLabels) {
        this.fieldLabels = fieldLabels;
        this.componentLabels = componentLabels;
        this.subComponentLabels = subComponentLabels;
        this.fieldDescriptions = fieldDescriptions;
    }

    /**
     * Constructor for Segments without subcomponents
     * @param componentLabels
     * @param fieldDescriptions
     * @param fieldLabels
     */
    Segment(Map<String, String[]> componentLabels,
            String[] fieldDescriptions,
            String... fieldLabels) {
        this.fieldLabels = fieldLabels;
        this.componentLabels = componentLabels;
        this.fieldDescriptions = fieldDescriptions;

    }

//    /**
//     *
//     * @param componentLabels
//     * @param fieldLabels
//     */
//    Segment(Map<String, String[]> componentLabels,
//            String... fieldLabels) {
//        this.fieldLabels = fieldLabels;
//        this.componentLabels = componentLabels;
//        this.subComponentLabels = new HashMap<>();
//    }
//
//    /**
//     *
//     * @param fieldLabels
//     */
//    Segment(String... fieldLabels) {
//        this.fieldLabels = fieldLabels;
//        this.componentLabels = new HashMap<>();
//        this.subComponentLabels = new HashMap<>();
//    }

    /**
     *
     * @return
     */
    public String[] getFieldLabels() {
        return fieldLabels;
    }

    /**
     *
     * @return
     */
    public Map<String, String[]> getComponentLabels() {
        return componentLabels;
    }

    /**
     *
     * @return
     */
    public Map<String, String[]> getSubComponentLabels() {
        return subComponentLabels;
    }

    /**
     *
     * @return
     */
    public String[] getFieldDescriptions() {
        return fieldDescriptions;
    }
}
