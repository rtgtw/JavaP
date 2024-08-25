package InnerClasses;


//Create an abstract class and then create an anonymous class to
//create an object of the abstract class
interface iInterface{
     void display();
}

abstract class Abstract1{
    public abstract void cook();
}

class Animal{
    int number = 4;

    //This is an anonymous class to complete the abstract class/interface
    //Can also be created inside of a method too
    static final iInterface i = new iInterface(){
        public void display(){
            System.out.println("Hello World");
        }
    };

    static final Abstract1 a = new Abstract1(){
        public void cook(){
            System.out.println("Cooking");
            i.display();
        }
    };


}

public class AnonymousClass {
    public static void main(String args[]){
        Animal.i.display();
        Animal.a.cook();
    }
}
