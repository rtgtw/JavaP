package Io;


import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class Producer extends Thread {
    java.io.OutputStream os;


    //Constructor
    Producer(OutputStream os){
        this.os = os;
    }

    //overwrite run method for multi threading
    synchronized public void run() {
        int count = 1;

        while(true) {
            try {
                os.write(count);
                os.flush();
                System.out.println("Producer is producing: " + count);
                System.out.flush();
                Thread.sleep(100);
                count++;
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

}


class Consumer extends Thread {
    InputStream is;


    //Constructor
    Consumer(InputStream is){
        this.is = is;
    }

    //overwrite run method for multi threading
    synchronized public void run() {
        int x;

        while(true) {
            try {
                x = is.read();
                System.out.println("Consumer: " + x);
                System.out.flush();
                Thread.sleep(100);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

}



public class PipedInputOutputStream {



    public static void main(String args[]) throws Exception{
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream();

        //Connect the pipes and start the thread
        pos.connect(pis);

        Producer p = new Producer(pos);
        Consumer c = new Consumer(pis);

        p.start();
        c.start();

    }


}
