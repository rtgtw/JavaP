package Multithreading;


//Write a class for the shared data
class MyData{
    int value;
    boolean flag = true;

    synchronized public void set(int v){
        while(flag != true){
            //makes this thread (producer wait)
            try{wait();}catch(Exception e){System.out.println(e);};
        }
        this.value = v;
        flag = false;
        //notifies other threads to start using this object
        notify();
    }

    synchronized public int get(){
        int x = 0;
        while(flag != false){
            //makes this thread (producer wait)
            try{wait();}catch(Exception e){System.out.println(e);};
        }

        x = value;
        flag = true;
        notify();
        return x;
    }
}


//Create producer class
class Producer extends Thread{

    MyData data;

    public Producer(MyData d){
        this.data = d;
    }

    public void run(){
        int count = 1;
        while(true){
            data.set(count);
            System.out.println("Producer: " + count);
            count++;
        }
    }
}


class Consumer extends Thread{
    MyData data;

    public Consumer(MyData data){
        this.data = data;
    }

    public void run(){
        int value;
        while(true){
            value = data.get();
            System.out.println("Consumer: " + value);
        }
    }


}


public class ProducerConsumer {
    public static void main(String args[]){
        MyData data = new MyData();
        Producer p = new Producer(data);
        Consumer c = new Consumer(data);

        //start the threads
        p.start();
        c.start();
    }
}
