package stringPractice;

//Consolidated without comments
public class GmailFindC {

    public boolean isGmail(String emailAddress){
        return emailAddress.matches("[a-zA-Z0-9]{1,16}@gmail\\.com");
    }
    public void printUserID(String emailAddress){
        int atSymbolLocation = emailAddress.indexOf("@");
        String userID = emailAddress.substring(0,atSymbolLocation);
        String email = emailAddress.substring(atSymbolLocation + 1);
        System.out.println("UserID: " + userID);
        System.out.println("Email: " + email);
    }
    public static void main(String args[]){
        String email = "heeeeem522@gmail.com";
        GmailFindC reference1 = new GmailFindC();

        boolean emailValidation = reference1.isGmail(email);

        if(emailValidation){
            System.out.println(email + " is a valid email");
            reference1.printUserID(email);
        } else {
            System.out.println(email + " is not a valid email");
        }
    }
}