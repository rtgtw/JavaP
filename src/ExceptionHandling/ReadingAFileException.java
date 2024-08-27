package ExceptionHandling;
import java.text.DecimalFormat;
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class ReadingAFileException {

    static int globalCounter = 0;
    static int numberOfProcesses = 0;

    static long totalRuntime = 0;

    static int globalCharacterCounter = 0;

    static void globalCount(){
        System.out.println(globalCounter + " " + numberOfProcesses + " " + totalRuntime);
    };

    static void reset(){
        //Resets global variables
        globalCounter = 0;
        numberOfProcesses = 0;
        totalRuntime = 0;
        System.out.println("Global Variables RESET!");
    }

    public static void method1(String filename, int stringNumber) throws Exception {

        //Start of method timing
        long startOfMethodTime = System.nanoTime();

        //Regex pattern
        String regexPattern = "[a-zA-Z]+";
        Pattern characterPattern = Pattern.compile(regexPattern);

        //format int create format object
        DecimalFormat df = new DecimalFormat("#,###");
        int overallCounter = 0;
        int successCounter = 0;
        int characterCounter = 0;

        //Start of read time
        long startOfReadTime = System.nanoTime();

        //try with resource try/catch
        //This is beneficial b/c you dont need to write a finally block in order to delete resources
        try( FileInputStream fi = new FileInputStream("C:\\Users\\remio\\OneDrive\\Desktop\\prompt.txt");
             Scanner sc = new Scanner(fi);
             PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\remio\\OneDrive\\Desktop\\" + filename + ".txt"))) {

             //End of read time (could use this for start of write time, but will create startWrite b/c reps
            long endOfReadTime = System.nanoTime();


            //Start of write time
            long startOfWriteTime = System.nanoTime();

            while(sc.hasNext()){
                String nextToken = sc.next();
                Matcher charMatcher = characterPattern.matcher(nextToken);
                if(nextToken.length() == stringNumber && charMatcher.matches()){
                pw.print(nextToken + " | ");
                characterCounter = characterCounter + nextToken.length();
                successCounter++;
                if(successCounter % 5 == 0){
                    pw.println(" ");
                    }
                }
                overallCounter++;
            }

            //Add to global character counter
            globalCharacterCounter = globalCharacterCounter + characterCounter;

            //End of Write time
            long endOfWriteTime = System.nanoTime();


            //End of method time
            long endOfMethodTime = System.nanoTime();

            //Time calculations (nanoseconds)
            long totalMethodTime = endOfMethodTime - startOfMethodTime;
            long totalReadTime = endOfReadTime - startOfReadTime;
            long totalWriteTime = endOfWriteTime - startOfWriteTime;

            //Nanoseconds to milliseconds conversion (divide by 1m)
            //one second is a thousand milliseconds
            float totalMethodTimeMilli = ((float)totalMethodTime / 1000000);
            float totalReadTimeMilli = ((float)totalReadTime / 1000000);
            float totalWriteTimeMilli = ((float)totalWriteTime / 1000000);

            //milliseconds to seconds conversion for MethodTime and WriteTime
            float totalMethodTimeSeconds = (totalMethodTimeMilli / 1000);
            float totalWriteTimeSeconds = (totalWriteTimeMilli / 1000);

            //Seconds w/ .000 precision
            double totalMethodTimeSeconds3Precision = Math.round(totalMethodTimeSeconds * 1000.0) / 1000.0;
            double totalWriteTimeSeconds3Precision = Math.round(totalWriteTimeSeconds * 1000.0) / 1000.0;


            //Static total runtime counter
            totalRuntime = totalRuntime + totalMethodTime;

            //Static total runtime nanoseconds -> milliseconds
            float totalRuntimeMilli = ((float)totalRuntime / 1000000);

            //Static total runtime milliseconds -> seconds
            float totalRuntimeSeconds = (totalRuntimeMilli / 1000);

            //total runtime seconds w/ 3 precision
            double totalRuntimeSeconds3Precision = Math.round(totalRuntimeSeconds * 1000.0)/ 1000.0;



            //Add this instance's overallCounter to the static globalCounter, to gage
            //how many words between all processes it went through
            globalCounter = globalCounter + overallCounter;

            //show how many processes this ran for
            numberOfProcesses++;



            System.out.println(" ");
            System.out.println("Process Complete, file: " + filename + ".txt has been created");
            System.out.println("Returned " + df.format(successCounter) + " words back to the user that had " +stringNumber + " characters in it");
            System.out.println("This process analyzed " + df.format(characterCounter) + " characters");
            System.out.println("This process analyzed " + df.format(overallCounter) + " words in total");
            System.out.println("Number of processes: " + numberOfProcesses );
            System.out.println("Number of total words for all processes: " + df.format(globalCounter) );
            System.out.println("Number of total characters for all processes: " + df.format(globalCharacterCounter) );
            System.out.println("It took this process " + totalReadTimeMilli + " milliseconds to read this file");
            System.out.println("It took this process " + totalWriteTimeSeconds3Precision + " seconds to write this file");
            System.out.println("It took this process " + totalMethodTimeSeconds3Precision + " seconds to processes request");
            System.out.println("Total Runtime for " + numberOfProcesses + " processes: " + totalRuntimeSeconds3Precision + " seconds");
            System.out.println("Closing program...");
            System.out.println(" ");
        }
    }


    public static void main(String args[]){
        try {
            //static method
            for(int i = 0; i < 15; i++) {
                ReadingAFileException.method1("bingBong1", 4);
                ReadingAFileException.method1("trippy41", 3);
                ReadingAFileException.method1("winnersCircle", 7);
            }
            ReadingAFileException.reset();
            //Pass in output file name, and number of strings
        }catch(Exception e){
            System.out.println("File was not found, try again.");
        }



        /*

        Output:

        Process Complete, file: winnersCircle.txt has been created
        Returned 361,680 words back to the user that had 7 characters in it
        This process analyzed 2,531,760 characters
        This process analyzed 6,095,760 words in total
        Number of processes: 45
        Number of total words for all processes: 274,309,200
        It took this process 0.7775 milliseconds to read this file
        It took this process 1.683 seconds to write this file
        It took this process 1.684 seconds to processes request
        Total Runtime for 45 processes: 78.553 seconds
        Closing program...

        Global Variables RESET!
        *
        *
        */

    }
}
