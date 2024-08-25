package stringPractice;

public class GmailFind {


    public static void main(String args[]){

        //create a method to find the user ID and Email address from string
        //Create a method to validate if string is a gmail email

        String email = "programmer@gmail.com";

        //Create regex only for gmail accounts
        //Pass in the string into a function and attach the .matches() method onto it

        //Create a method inside of the GmailFind class
        //Method should return a boolean, true or false, method should be public
        //Challenge, create a static and non-static version

        //Create an instance (object of class GmailFind)
        //The the reference, references the object that was created in this class
        GmailFind reference1 = new GmailFind();

        //Use this new reference to call on the method created within this class
        //pass in the string
        boolean emailValidation = reference1.isGmail(email);


        //static version
        //Static means you do not have to create an object to run the method
        //it can be run directly within the class
        boolean emailValidationStatic = isGmailStatic(email);


        //Only call printUserID if the email is valid
        if(emailValidation){
            System.out.println(email + " is a valid email");
            reference1.printUserID(email);

        } else{
            System.out.println(email + " is not a valid email");
        }

//        if(emailValidationStatic){
//            System.out.println(email + " is a valid email, and this is the static version");
//        } else{
//            System.out.println(email + " is not a valid email, and this is the static version");
//        }




    }


    //Pass in the string to the method
    public boolean isGmail(String emailAddress){
        //Create regex for gmail accounts
        //1-16 characters, a-zA-Z0-9
        //This regex confirms this email is a gmail email
        //We can directly return this to caller, no need to create a variable

        return emailAddress.matches("[a-zA-Z0-9]{1,16}@gmail\\.com");
    }

    public static boolean isGmailStatic(String emailAddress){

        return emailAddress.matches("[a-zA-Z0-9]{1,16}@gmail\\.com");
    }


    //Create a method that takes the substring from string before the @ and after the @
    public void printUserID(String emailAddress){

        //Can start by using indexOf to find where the index of the @ is
        //Returns an int, store this
        int atSymbolLocation = emailAddress.indexOf("@");

        //Start from the beginning of the string array all the way to atSymbol
        //Since we are not including the @ symbol, we dont have to do +1
       String userID = emailAddress.substring(0,atSymbolLocation);

       //to find the email we start with the @ symbol + 1 and only pass in that parameter
        //since it will take the rest of the substring for us
        String email = emailAddress.substring(atSymbolLocation + 1);

        //Can pass this into a hashmap or something but ill just output it here

        System.out.println("UserID: " + userID);
        System.out.println("Email: " + email);


    }




}
