package Multithreading;
import java.lang.*;

class MyThread extends Thread{

    public void run(){

        for(int i = 0; i <1000000000; i++ ){
            System.out.println("Running from thread one which is from MyThread class");
        }
    }

}

public class Multithreading extends Thread {

    public void run(){
        for(int i = 0; i <1000000000; i++ ){
            System.out.println("Running from thread 2, which is inside of main");
        }
    }

    public static void main(String args[]){
        MyThread thread1 = new MyThread();
        Multithreading thread2 = new Multithreading();

        thread1.start();
        thread2.start();

        for(int i = 0; i <1000000000; i++ ){
            System.out.println("Running from inside of main");
        }
    }

}
