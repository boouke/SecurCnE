import java.io.*;

public class RunLengthEncoding {
    ExceptionCatcher exceptionCatcher = new ExceptionCatcher();

    public boolean RLEencode() {
        System.out.println("RLE selected. Please type a string to compress. Note-Only text in line 1 will be compressed.");
        String unencodedString = "";
        StringBuilder encodedString = new StringBuilder();
        String filePath = "../file/initialFile.txt";
        String encodedFilePath = "../file/compressedFile.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            unencodedString = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        int count = 1;

        for (int i = 0; i < unencodedString.length(); i++) {
            char character = unencodedString.charAt(i);
            if (Character.isDigit(character)){
                System.out.println(TechnicalWarningConstants.w0x91);
                return false;
            }
        }

        for (int i = 1; i < unencodedString.length(); i++) {
            if (unencodedString.charAt(i) == unencodedString.charAt(i - 1)) {
                count++;
            } else {
                if (count == 1){
                    encodedString.append(unencodedString.charAt(i - 1));
                }
                else {
                    encodedString.append(unencodedString.charAt(i - 1)).append(count);
                    count = 1;
                }
            }
        }
        if (count == 1) {
            encodedString.append(unencodedString.charAt(unencodedString.length() - 1));
        }
        else {
            encodedString.append(unencodedString.charAt(unencodedString.length() - 1)).append(count);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(encodedFilePath))) {
            writer.write(encodedString.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stopwatch.stop());
        return true;
    }

    public void RLEdecode() {
        String filePath = "../file/compressedFile.txt";
        String decodedFilePath = "../file/uncompressedFile.txt";
        String encodedString = "";
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            encodedString = reader.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }

        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        StringBuilder decodedString = new StringBuilder();

        for (int i = 0; i < encodedString.length(); i++) {
            char character = encodedString.charAt(i);
            if (i + 1 < encodedString.length() && Character.isDigit(encodedString.charAt(i + 1))) {
                StringBuilder countBuilder = new StringBuilder();
                while (i + 1 < encodedString.length() && Character.isDigit(encodedString.charAt(i + 1))) {
                    countBuilder.append(encodedString.charAt(++i));
                }
                int count = Integer.parseInt(countBuilder.toString());
                for (int j = 0; j < count; j++) {
                    decodedString.append(character);
                }
            } else {
                decodedString.append(character);
            }
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(decodedFilePath))){
            writer.write(decodedString.toString());
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(stopwatch.stop());
    }
}
