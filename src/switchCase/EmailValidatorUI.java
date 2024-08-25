package switchCase;
import java.lang.*;
import java.util.regex.*;

//java swing contains all the classes needed to create a gui
//has JFrame, JButton, JOptionPane etc
import javax.swing.*;

//Action event class represents an action that occurs when an action is performed
import java.awt.event.ActionEvent;

//imports the actionlistener interface, needs to be implemented by any class
//that plans to respond to action events
import java.awt.event.ActionListener;


//1. Check if the email address is valid or not, notify the user
//2. Let the user know the username portion and the domain portion
//3. Let the user know if it is a gmail domain or not
//4. let the user know the metrics of their username
//5. UI
//Model view controller MVC architecture


//front end logic
public class EmailValidatorUI{

    //Declare reference from backend class SwitchValidEmail
    private final SwitchValidEmail validator;


    //Create a constructor for EmailValidator UI which will essentially
    //load up the UI upon creating an instance of email validator UI
    public EmailValidatorUI(){

        //create an instance of the backend class
        validator = new SwitchValidEmail();

        //Set up JFrame, which is a top-level container that will create a windows
        //on the screen
        //Use JFrame Class and create a new object(instance)
        JFrame frame = new JFrame("Email Validator");

        //Use a method within JFrame class to set the size of the window (pixels)
        frame.setSize(1400,800);

        //set up the close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create a button object from the JButton class
        JButton button = new JButton("Validate Email");


        //We need to add the button to the frame
        frame.add(button);

        //We have to add an action listener to the button
        //We are going to create an anonymous class in order to implement
        //the ActionListener interface
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = JOptionPane.showInputDialog(frame,"Please enter your email");

                //check to see if user entered any null values or exited (which is null)
                if(email != null){

                    if(validator.validEmail(email)){
                        JOptionPane.showMessageDialog(frame,"Hurray! This is a valid email");
                        validator.usernameAndDomain(email,frame);
                        if(validator.isGmail(email)){
                            JOptionPane.showMessageDialog(frame,"Not only is this a valid email, but its also a Google Email");
                        }else{
                            JOptionPane.showMessageDialog(frame,"This is a valid email, however, this is not a Google Email");
                        }

                        validator.metrics(email,frame);
                    }else{
                        JOptionPane.showMessageDialog(frame, "Error, this was not a valid email. Try again");
                    }
                }else{
                    JOptionPane.showMessageDialog(frame, "Error, this was not a valid email. Try again");
                }
            }
        });

        frame.setVisible(true);
    }


    public static void main(String args[]){
        //create an instance of the class and let the constructor run it
        new EmailValidatorUI();
    }

}





//backend logic
class SwitchValidEmail {

    public boolean validEmail(String email){
        return email.matches("[a-zA-Z0-9]{1,16}@[a-zA-Z]{1,16}\\.[a-zA-Z]{3,10}");
    }

    public void usernameAndDomain(String email, JFrame frame){
        //get index value of @ sign
        int atSymbolIndex = email.indexOf('@');

        String username = email.substring(0,atSymbolIndex);
        String domain = email.substring(atSymbolIndex + 1, email.length());

        System.out.println("Your Username: " + username);
        System.out.println("Your Domain: " + domain);

        JOptionPane.showMessageDialog(frame, "Your Username: " + username + "\nYour Domain: " + domain);
    }

    public boolean isGmail(String email){

        //find index of at symbol
        int atSymbolIndex = email.indexOf('@');

        String domain = email.substring(atSymbolIndex + 1, email.length());

        //convert it all to lowercase
        domain = domain.toLowerCase();


        if(domain.equals("gmail.com")){
            return true;
        }
        return false;
    }



    public void metrics(String email, JFrame frame){

        int i = 0;
        int charCount = 0;
        int numberCount = 0;
        String regexChar = "[a-zA-z]";
        String regexNumber = "[0-9]";
        //each character within the string array
        char characterValue;

        //matcher, compile both the regex patterns
        //compile is a static method
        //you pass in the string that holds the regex pattern
        Pattern charPattern = Pattern.compile(regexChar);
        Pattern numberPattern = Pattern.compile(regexNumber);


        //Get the index of at Symbol
        int atSymbolIndex = email.indexOf('@');

        //reassign email to the username portion
        //Strings are immutable, so it destroys and creates a whole new string
        email = email.substring(0,atSymbolIndex);

        //use charAt to access values
        while(i < email.length()){

            //Get the char value at the current index
            characterValue = email.charAt(i);

            //Convert this back into a string
            //only way we'll be able to use .matcher, it requires a string not char
            String charToString = String.valueOf(characterValue);

            //Check the matcher for both cases
            Matcher charMatcher = charPattern.matcher(charToString);
            Matcher numberMatcher = numberPattern.matcher(charToString);

            if(charMatcher.matches()){
                charCount++;
                i++;
            } else if(numberMatcher.matches()){
                numberCount++;
                i++;

            }
            //there shouldnt be an else, it should either be a char or number
            //but included it anyways
            else{
                i++;
            }
        }

        System.out.println("Your username has: " + charCount + " characters and " + numberCount + " numbers!");
        JOptionPane.showMessageDialog(frame, "Your username has: " + charCount + " characters and " + numberCount + " numbers!");
    }
}
