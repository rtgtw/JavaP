package Multithreading;
import switchCase.EmailValidatorUI;
import ExceptionHandling.ReadingAFileException;


public class MultithreadingString extends Thread {

    //override run
    public void run(){
        EmailValidatorUI validator = new EmailValidatorUI();
    }


    public static void main(String args[]){

        //Run the validator three times concurrently
        MultithreadingString thread1 = new MultithreadingString();

        thread1.start();

        try {
            for(int i = 0; i < 20; i++) {
                ReadingAFileException.method1("winnersCircle1", 7);
                ReadingAFileException.method1("winnersCircle2", 6);
                ReadingAFileException.method1("winnersCircle3", 5);
            }
        }catch(Exception e){
            System.out.println(e);
        }



        System.out.println("Entered this area");

    }


}
