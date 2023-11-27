public class Stopwatch {
    private long startTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public String stop() {
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        // Convert nanoseconds to seconds and milliseconds
        double seconds = (double) elapsedTime / 1_000_000_000.0;
        double milliseconds = (double) elapsedTime / 1_000_000.0;

        // Format the result as s.ms
        return String.format("%.3f", seconds) + " s (" + String.format("%.3f", milliseconds) + " ms)";
    }
}