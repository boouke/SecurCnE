import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExceptionCatcher {
    public String stringValidate(){
        boolean validInput = false;
        String errorCode;
        boolean corePanicState = false;
        String stringToValidate = "";
        Scanner scan = new Scanner(System.in);
        while (!validInput) {
            try {
                stringToValidate = scan.next();
                validInput = true;
            } catch (NoSuchElementException e) {
                errorCode = "e0x01";
                System.out.println(TechnicalErrorConstants.e0x01);
                Error.logError(e, errorCode, corePanicState);
                System.exit(1);
            } catch (IllegalStateException e) {
                errorCode = "e0x11";
                corePanicState = true;
                System.out.println(TechnicalErrorConstants.coreErrorStart + TechnicalErrorConstants.e0x11 + TechnicalErrorConstants.coreErrorEnd + TechnicalErrorConstants.corePanic);
                Error.logError(e, errorCode, corePanicState);
                System.exit(1);
            }
        }
        return stringToValidate;
    }
}
