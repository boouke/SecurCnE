import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Error {
    public static void logError(Exception e, String errorCode, boolean corePanicState) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd___HH-mm-ss").format(new Date());
        String filename = "logs/err" + timestamp + ".dmp";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            if (corePanicState){
                writer.write("\n" + "[" + timestamp + "] - " + TechnicalErrorConstants.coreErrorStart + TechnicalErrorConstants.e0x11 + TechnicalErrorConstants.coreErrorEnd + TechnicalErrorConstants.corePanic + "\n-----------------------------------------------------------------------------------------------------------\nStack trace:\n\n");
            } else{
                writer.write("\n" + "[" + timestamp + "] - " + errorCode + "\n-----------------------------------------------------------------------------------------------------------\nStack trace:\n\n");
            }

            e.printStackTrace(writer);
            System.out.println("Error logged in external file.");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
