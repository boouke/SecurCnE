import java.util.Scanner;

public class Choice {
    Scanner scan = new Scanner(System.in);
    ExceptionCatcher exceptionCatcher = new ExceptionCatcher();

    String userFlag = "";
    boolean validInput = false;

    private int setChoiceFlag(){
        System.out.println("Compression or encryption?\n");

        String testValue = scan.next();
        if (testValue.equals("error")) {
            scan.close();
        }
        if (testValue.equals("rle")) {
            RunLengthEncoding RLE = new RunLengthEncoding();
            RLE.RLE();
            System.exit(1);
        }

        userFlag = exceptionCatcher.stringValidate();
        System.out.println("debug: " + userFlag);

        return (userFlag.equals("compression")) ? 1 : 0;
    }
    public String choiceFunc(){
        int choiceFlag = setChoiceFlag();
        System.out.println("debug: " + choiceFlag);

        switch(choiceFlag){
            case 1:
                System.out.println("Selected compression");
                userFlag = exceptionCatcher.stringValidate();

                while(!userFlag.equals("RLE")){
                    System.out.println(TechnicalWarningConstants.w0x01);
                    userFlag = exceptionCatcher.stringValidate();
                }

                RunLengthEncoding RLE = new RunLengthEncoding();
                validInput = true;
                String compressedString = RLE.RLE();
                return compressedString;
            case 2:

                break;
        }
        return null;
    }
}
