package ExceptionHandling;
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ReadingAFileException {
    static void method1(String filename, int stringNumber) throws Exception{

        String regexPattern = "[a-zA-Z]*";
        Pattern characterPattern = Pattern.compile(regexPattern);
        int overallCounter = 0;
        int successCounter = 0;

        //try with resource try/catch
        //This is beneficial b/c you dont need to write a finally block in order to delete resources
        try( FileInputStream fi = new FileInputStream("C:\\Users\\nonono\\OneDrive\\Desktop\\prompt.txt");
             Scanner sc = new Scanner(fi);
             PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\nonono\\OneDrive\\Desktop\\" + filename + ".txt"))) {


            while(sc.hasNext()){
                String nextToken = sc.next();
                Matcher charMatcher = characterPattern.matcher(nextToken);
                if(nextToken.length() == stringNumber && charMatcher.matches()){
                pw.print(nextToken + " ");
                successCounter++;
                if(successCounter % 5 == 0){
                    pw.println(" ");
                    }
                }
                overallCounter++;
            }

            System.out.println(" ");
            System.out.println("Process Complete, file: " + filename + ".txt has been created");
            System.out.println("Returned " + successCounter + " words back to the user that had " +stringNumber + " characters in it");
            System.out.println("This process analyzed " + overallCounter + " words");
            System.out.println("Closing program...");
            System.out.println(" ");
        }
    }


    public static void main(String args[]){
        try {
            //static method
            ReadingAFileException.method1("bingBong1", 4);
            ReadingAFileException.method1("trippy41", 3);
            ReadingAFileException.method1("winnersCircle", 7);

            //Pass in output file name, and number of strings
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
