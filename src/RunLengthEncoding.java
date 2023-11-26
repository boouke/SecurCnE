import java.io.*;

public class RunLengthEncoding {
    ExceptionCatcher exceptionCatcher = new ExceptionCatcher();

    public String RLE(){
        System.out.println("RLE selected. Please type a string to compress.");
        String uncompressedString = "aaA";
        //String uncompressedString = exceptionCatcher.stringValidate();
        StringBuilder compressedString = new StringBuilder();
        String filePath = "file/file.txt";
        String compressedFilePath = "file/compressedFile.txt";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            uncompressedString = bufferedReader.readLine();
        }   catch (IOException e){
            e.printStackTrace();
        }

        int count = 1;


        for (int i = 1; i < uncompressedString.length() ; i++) {
            if (uncompressedString.charAt(i) == uncompressedString.charAt(i-1)) {
                count++;
            }
            else{
                if (count == 1){
                    compressedString.append(uncompressedString.charAt(i-1));
                }
                else {
                    compressedString.append(uncompressedString.charAt(i-1)).append(count);
                }
                count = 1;
            }
        }
        if (count == 1){
            compressedString.append(uncompressedString.charAt(uncompressedString.length() - 1));
        }
        else {
            compressedString.append(uncompressedString.charAt(uncompressedString.length() - 1)).append(count);
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(compressedFilePath))){
            writer.write(compressedString.toString());
        }   catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(uncompressedString);
        System.out.println(compressedString);
        return compressedString.toString();
    }
}
