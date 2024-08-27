package ExceptionHandling;
import java.io.*;

//minimum balance in a bank account
class MinBalanceException extends Exception{

    //need to override Exceptions toStrong() and getMessage()
    public String toString(){
        return "Minimum Balance should not be less than 5000, change the amount and try again";
    };

}



class ExceptionCase{




    public static void method2(){
        try{
            throw new MinBalanceException();
        }catch(MinBalanceException e){
            System.out.println(e);
        }

    }
    public static void method1(){

        //try and catch block
    try {
        int a, b, c;
        a = 5;
        b = 0;
        c = a / b;
        System.out.println("Result is " + c);
        //This can also just be Exception which catches everything in the subclasses
        //checked or unchecked
    }catch(ArithmeticException e){
        System.out.println("Error, cannot divide by 0 | " + e);
//        e.printStackTrace();
    }
    System.out.println("End of program");
    System.out.println("Bye!");

    }
}


public class HandleException {

    public static void main(String args[]){
        ExceptionCase.method2();
    }
}
