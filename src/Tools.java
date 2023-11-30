import java.io.*;

public class Tools {
    private long startTime;

    public void stopwatchStart() {
        startTime = System.nanoTime();
    }

    public String stopwatchStop() {
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        double seconds = (double) elapsedTime / 1_000_000_000.0;
        double milliseconds = (double) elapsedTime / 1_000_000.0;

        return String.format("%.3f", seconds) + " s (" + String.format("%.3f", milliseconds) + " ms)";
    }
    public boolean removeNumbers(String filePath){
        String initialData = "";

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            initialData = reader.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }

        StringBuilder outputData = new StringBuilder();
        for (int i = 0; i<=initialData.length() - 1; i++){
            char character = initialData.charAt(i);
            if (!Character.isDigit(character)) {
                outputData.append(character);
            }
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("../file/initialFile.txt"))){
            writer.write(outputData.toString());
        } catch (IOException e){
            e.printStackTrace();
        }
        return true;
    }
}
