import java.lang.String;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("The system is initializing..");
        Random random = new Random();
        long startTime = System.currentTimeMillis();
        Thread.sleep(random.nextInt(2000));
        double elapsedTime = (double) (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("Initialized succesfully! (" + elapsedTime + ")");
        choice();
    }
    private static int setChoiceFlag(){
        Scanner scan = new Scanner(System.in);
        int choiceFlag = 0;
        boolean validInput = false;
        System.out.println("Compression or encryption?");
/*
while (!validInput) {
     try {
         choiceFlag = scan.nextInt();
         while(choiceFlag != 1 && choiceFlag != 2){
             System.out.println("Please select either 1 or 2.");
             choiceFlag = scan.nextInt();
         }
         validInput = true;
     } catch (java.util.InputMismatchException e) {
         System.out.println("Please select either 1 or 2.");
     }
 }
*/
        while(!validInput) {
            try {
                String unconvertedChoice = scan.next();
                validInput = true;
            }   catch(java.util.NoSuchElementException NSEX){
                System.out.println(TechnicalErrorConstants.e0x01 + ErrorMessagesConstants.msg0x01);
            }
        }
        return choiceFlag;
    }
    private static void choice(){
        int choiceFlag = setChoiceFlag();
        switch(choiceFlag){
            case 1:
                System.out.println("Selected compression");
                System.out.println("What algorythm do you want to use?");
                break;
            case 2:

                break;
        }
    }
}