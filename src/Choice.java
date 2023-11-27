import java.util.Scanner;

public class Choice {
    Scanner scan = new Scanner(System.in);
    ExceptionCatcher exceptionCatcher = new ExceptionCatcher();

    String userFlag = "";

    private int setChoiceFlag(){
        System.out.println("Compression or encryption?\n");

        String testValue = scan.next();
        if (testValue.equals("error")) {
            scan.close();
        }
        else if (testValue.equals("rle")) {
            RunLengthEncoding RLE = new RunLengthEncoding();
            RLE.RLEencode();
        }
        else if (testValue.equals("urle")){
            RunLengthEncoding RLE = new RunLengthEncoding();
            RLE.RLEdecode();
        }

        userFlag = exceptionCatcher.stringValidate();
        System.out.println("debug: " + userFlag);

        return (userFlag.equals("compression")) ? 1 : 0;
    }
    public void choiceFunc(){
        int choiceFlag = setChoiceFlag();
        System.out.println("debug: " + choiceFlag);

        switch(choiceFlag){
            case 1:
                System.out.println("Selected compression || Encoding(encode), or decryption?(decrypt)");
                userFlag = exceptionCatcher.stringValidate();

                while(!userFlag.equalsIgnoreCase("RLE") && !userFlag.equalsIgnoreCase("decrypt")) {
                    System.out.println(TechnicalWarningConstants.w0x01);
                    userFlag = exceptionCatcher.stringValidate();
                }
                if (userFlag.equalsIgnoreCase("encode")) {
                    RunLengthEncoding RLE = new RunLengthEncoding();
                    RLE.RLEencode();
                }
                else if(userFlag.equalsIgnoreCase("decrypt")){
                    RunLengthEncoding RLE = new RunLengthEncoding();
                    RLE.RLEdecode();
                }
                break;
            case 2:

                break;
        }
    }
}
