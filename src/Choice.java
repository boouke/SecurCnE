import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Scanner;

public class Choice {
    Scanner scan = new Scanner(System.in);
    ExceptionCatcher exceptionCatcher = new ExceptionCatcher();

    String userFlag = "";

    private int setChoiceFlag(){
        System.out.println("Compression or encryption?\n(Write C or E)");

        Tools tools = new Tools();

        userFlag = exceptionCatcher.stringValidate();
        while(!userFlag.equalsIgnoreCase("rle") && !userFlag.equalsIgnoreCase("error") && !userFlag.equalsIgnoreCase("urle") && !userFlag.equalsIgnoreCase("e") && !userFlag.equalsIgnoreCase("c")){
            System.out.println(TechnicalWarningConstants.w0x01);
            userFlag = exceptionCatcher.stringValidate();
        }
        if (userFlag.equalsIgnoreCase("error")) {
            scan.close();
        } else if (userFlag.equalsIgnoreCase("rle")) {
            RunLengthEncoding RLE = new RunLengthEncoding();
            if(RLE.RLEencode() == false){
                System.out.println("Please remove all numbers from the uncompressed files. Do you want the program to do it automatically? (Write yes or no)");
                userFlag = exceptionCatcher.stringValidate();
                while(!userFlag.equalsIgnoreCase("yes") && !userFlag.equalsIgnoreCase("no")){
                    System.out.println(TechnicalWarningConstants.w0x01);
                    userFlag = exceptionCatcher.stringValidate();
                }
                if (userFlag.equalsIgnoreCase("yes")) {
                    File file = new File("../file/initialFile.txt");
                    System.out.println("Are you sure? The file you are trying to encrypt is " + file.length() / 1024 + "kb / " + file.length() / (1024 * 1024) + "mb");
                    tools.removeNumbers("../file/initialFile.txt");
                }
            }
        } else if (userFlag.equalsIgnoreCase("urle")){
            RunLengthEncoding RLE = new RunLengthEncoding();
            RLE.RLEdecode();
        }
        //System.out.println("debug: " + userFlag);

        return (userFlag.equalsIgnoreCase("c")) ? 1 : 0;
    }
    public void choiceFunc(){
        int choiceFlag = setChoiceFlag();
        //System.out.println("debug: " + choiceFlag);

        switch(choiceFlag){
            case 1:
                System.out.println("Selected compression.\n(Write encode or decode)");
                userFlag = exceptionCatcher.stringValidate();

                while(!userFlag.equalsIgnoreCase("encode") && !userFlag.equalsIgnoreCase("decode")) {
                    System.out.println(TechnicalWarningConstants.w0x01);
                    userFlag = exceptionCatcher.stringValidate();
                }
                if (userFlag.equalsIgnoreCase("encode")) {
                    RunLengthEncoding RLE = new RunLengthEncoding();
                    RLE.RLEencode();
                } else if(userFlag.equalsIgnoreCase("decode")){
                    RunLengthEncoding RLE = new RunLengthEncoding();
                    RLE.RLEdecode();
                }
                break;
            case 2:

                break;
        }
    }
}
