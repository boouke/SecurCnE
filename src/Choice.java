import java.util.NoSuchElementException;
import java.util.Scanner;

public class Choice {
    private int setChoiceFlag(){
        String errorCode;
        boolean corePanicState = false;
        String unconvertedChoice = "";
        boolean validInput = false;
        Scanner scan = new Scanner(System.in);

        System.out.println("Compression or encryption?\n");
        while(!validInput) {
            try {
                String testValue = scan.next();
                if(testValue.equals("error")){scan.close();}
                unconvertedChoice = scan.next();
                validInput = true;
            }   catch(NoSuchElementException e){
                errorCode = "e0x01";
                System.out.println(TechnicalErrorConstants.e0x01);
                Error.logError(e, errorCode, corePanicState);
                System.exit(1);
            }   catch(IllegalStateException e){
                errorCode = "e0x11";
                corePanicState = true;
                System.out.println(TechnicalErrorConstants.coreErrorStart + TechnicalErrorConstants.e0x11 + TechnicalErrorConstants.coreErrorEnd + TechnicalErrorConstants.corePanic);
                Error.logError(e, errorCode, corePanicState);
                System.exit(1);
            }
        }
        //System.out.println(unconvertedChoice);
        return (unconvertedChoice.equals("compression")) ? 1 : (unconvertedChoice.equals("encryption")) ? 2 : 0;
    }
    public void choiceFunc(){
        int choiceFlag = setChoiceFlag();
        System.out.println(choiceFlag);
        switch(choiceFlag){
            case 1:
                System.out.println("Selected compression");
                System.out.println("What algorithm do you want to use?");
                break;
            case 2:

                break;
        }
    }
}
