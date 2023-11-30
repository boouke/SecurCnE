public class TechnicalErrorConstants {
    public static final String coreErrorStart = "\n-----------------------------------------------------------------------------------------------------------\nCORE ERROR - UNEXPECTED CORE STATE.\n-----------------------------------------------------------------------------------------------------------\nException : ";
    public static final String coreErrorEnd = "\n-----------------------------------------------------------------------------------------------------------\nThe core of the application has encountered a potentially fatal error.\n-----------------------------------------------------------------------------------------------------------";
    public static final String corePanic = "\n\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\ncore_integrity_compromised\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\nCORE PANIC! - Application core will be shutdown to prevent any further damage.\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
    public static final String e0x01 = "e0x01 - The input data appears to be null or marked as 0 bytes, causing an inability to handle the processing.";
    public static final String e0x02 = "e0x02 - The program has hit a critical error, input is in an unsupported format for this operation. Process halted at breakpoint. ";
    public static final String e0x11 = "e0x11 - Illegal state encountered. The program is in an unexpected state and cannot proceed, this indicates a critical issue in the program's flow.";
    public static final String e0x21 = "e0x21 - Incorrect or corrupt file metadata requested or posted by the program. Program halted at breakpoint.";
    public static final String e0x22 = "e0x22 - The file pointer appears to be null, or marked as 0 bytes, causing an inability to handle the processing. (Maybe the files at file/ are empty?)";
}
