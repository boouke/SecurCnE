public class TechnicalErrorConstants {
    public static final String coreErrorStart = "\n-----------------------------------------------------------------------------------------------------------\nCORE ERROR - UNEXPECTED CORE STATE.\n-----------------------------------------------------------------------------------------------------------\nException : ";
    public static final String coreErrorEnd = "\n-----------------------------------------------------------------------------------------------------------\nThe core of the application has encountered a potentially fatal error.\n-----------------------------------------------------------------------------------------------------------";
    public static final String corePanic = "\n\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\ncore_integrity_compromised\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\nCORE PANIC! - Application core will be shutdown to prevent any further damage.\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
    public static final String exitMsg = "\n\nPress enter to shut down the program. Before you do so, write down the error codes.";
    public static final String e0x01 = "e0x01 - The input data appears to be null or marked as 0 bytes, causing an inability to handle the processing. This anomaly suggests a potential corruption in the data flow, leading to an illegal state.";
    public static final String e0x02 = "e0x02 - The program has hit a critical error, input is in an unsupported format for this operation. Process halted at breakpoint. ";
    public static final String e0x11 = "e0x11 - Illegal state encountered. The program is in an unexpected state and cannot proceed, this indicates a critical issue in the program's flow.";
}
