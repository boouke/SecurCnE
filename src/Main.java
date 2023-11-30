import java.lang.String;

public class Main {
    public static void main(String[] args){
        Choice choice = new Choice();
        int run = 0;
        while (true) {
            if (run == 0) {
                System.out.println("\nSystem started.");
            } else {
                System.out.println("\nSystem resetted.");
            }
            choice.choiceFunc();

        }

    }
}