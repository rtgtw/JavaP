package Interfaces;

//A store and a customer communicate with each other via an interface
//customer will implement the member interface which has a callback function


//Create member interface which will be used to communicate w/ store and customer
//Customer will implement the member interface

interface Member{
    void callback(String notification);
}

//Create the store class
class Store{

    //First we want to store multiple Member objects inside of an array
    //We also need to create a counter to keep count of each member
    private Member mem[] = new Member[100];
     private int count = 0;

    //Now we need to create a register method which will register a member object
    //and hold its value, we want to pass in the member object
    public void register(Member m){

        System.out.println("Added Member #" +count + " to the member list" );

        //Store the member inside of the array of Members
        mem[count++] = m;
        //Now store has a reference to the location of the member
   }

   //Now that the store has a reference to the member's location, we can
    //trigger the callback function that member, and it will make the call
    //Store can do this since it has its reference now
    public void saleNotification(String notification){

        //Use a for loop to iterate through each member in the member array and call
        //the callback method
        for(int i = 0; i < count; i++){
            //the member object (which was retrieved from the register method)
            //has the address location of the customer, now we trigger that method
            //and the customer will receive it
            //essentially we are triggering a call inside of the customer class within the store class
            mem[i].callback(notification);
        }
    }
}


class Customer implements Member{
    private String name;

    Customer(String name){
        this.name = name;
    }

    public void callback(String notification){
        System.out.println(name + " " + notification);
    };
}



public class StoreAPI {

    public static void main(String args[]) {
        Store s1 = new Store();
        Customer c1 = new Customer("Billy");
        Customer c2 = new Customer("John");
        Customer c3 = new Customer("Gabe");

        //First you have to register the customers so you can have an address
        //of the member interface, which can communicate directly with the customer
        //so we do not have the address of the customer, we have the address of the member interface
        //which can communicate with the customer
        s1.register(c1);
        s1.register(c2);
        s1.register(c3);

        s1.saleNotification("COUCH FOR SALE! STOP BY THE STORE!");
    }
}
