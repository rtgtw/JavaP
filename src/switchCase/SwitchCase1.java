package switchCase;

import java.lang.*;
import java.util.*;

public class SwitchCase1 {

    public void checkFruit(int fruit){

        switch(fruit){

            case 1:
                System.out.println("This is an apple");
                break;

            case 2:
                System.out.println("This is a bananas");
                break;
            case 3:
                System.out.println("Pineapple");
                break;

            default:
                System.out.println("This is not a fruit");
                break;
        }
    }




    public static void main(String args[]){

        //Create a new instance(object) of the class
        SwitchCase1 object1 = new SwitchCase1();

        //Create a new scanner object to read the value of the user
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Enter a Number from 1 - 3 to get the Fruit");

        //Create int value to hold the int input
        int inputValue = scanner1.nextInt();

        //Pass that value into the method
        object1.checkFruit(inputValue);

    }




}
