package Multithreading;

 class ATM{
    //class should be synchronized
    //Make sure there is only one instance of an ATM (singleton)
    private static final ATM instance = new ATM();

    //make atm constructor private, to make it a singleton
    private ATM(){};

      synchronized void checkBalance(String name){
         System.out.println(" ");
        System.out.println(name + " is checking the balance right now");
    }

      synchronized void withdraw(String name, int amount){
        System.out.println(name + " has withdrawn " + amount + " dollars");
          System.out.println(" ");
    }

    //use static method getATM to get the instance of ATM
    //the reference (instance) is static, however the object is not static
    //meaning getATM sends us back the reference of the object which is not static so we can
    //use non-static methods on this
    public static ATM getATM(){
        return instance;
    }

}

class Customer extends Thread{

    //This class should extend thread since multiple customers will be using the atm
    String name;
    int amount;
    ATM atm;

    //Customer constructor
    Customer(String name, int amount){
        this.name = name;
        this.amount = amount;
    }


    void useATM() {
        //gets a reference of the singleton,
        //which can use non-static methods
        //we can pass the static method directly with the dot operator or with ATM variable
        //ill do both for reps
        atm = ATM.getATM();

        ATM.getATM().checkBalance(name);
        atm.withdraw(name, amount);
    }

    //This should be inside of a thread, override run and use start to start the thread
    public void run() {
        this.useATM();
    }

}



public class AtmMachine {
     public static void main(String args[]){

     Customer c1thread = new Customer("John",40000);
     Customer c2thread = new Customer("Brian", 22000);

     c1thread.start();
     c2thread.start();
     }
}
