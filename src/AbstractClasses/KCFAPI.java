package AbstractClasses;



//In this abstract class KFC has the secret recepie in which the subclasses (franchises)
//inherits, they also have to define two abstract classes as well
abstract class KFC{

    //constructor
    KFC(){
        System.out.println("KFC Constructor");
    }

    void makeItem(){
        System.out.println("This is the super secret receipe that we are giving your franchise ");
    }

    //abstract methods
    abstract void billing();
    abstract void offers();
}


class MyKFC extends KFC{

    MyKFC(){
        System.out.println("This is MyKFC constructor");
    }

    void billing(){
        System.out.println("MyKFC implementing Billing");
    };

    void offers(){
        System.out.println("MyKFC implementing offers");
    };

}




public class KCFAPI {

    public static void main(String args[]){

        //dynamic method dispatch
        KFC kfc1 = new MyKFC();

        kfc1.offers();
    }
}
