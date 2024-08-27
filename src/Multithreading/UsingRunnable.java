package Multithreading;

//Using runnable interface, have to create an object(instance) of thread
//and pass in class w/ runnable interface into the constructor

public class UsingRunnable implements Runnable {

    public void run(){
        while(true) {
            System.out.println("hello");
        }
    }

    public static void main(String args[]){
        UsingRunnable ref1 = new UsingRunnable();
        Thread thread1 = new Thread(ref1);
        thread1.start();

        while(true){
            System.out.println("World");
        }
    }
}
