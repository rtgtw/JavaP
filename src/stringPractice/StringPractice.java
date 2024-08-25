package stringPractice;

public class StringPractice {


    public static void main(String args[]){

        //In the string pool
        String str1 = "Java";

        //1 object inside the heap 1 inside the string pool
        String str2 = new String("JAVA");

        char c[] = {'h','i'};
        String str3 = new String(c);

        int lengthOfString;

        //.length finds the length of the string
        lengthOfString = str1.length();

        //string objects are immutable, so when you use str4.toLowerCase()
        //it is literally creating a new string to do this
        String str4 = new String(str1.toLowerCase());



        System.out.println(str4);


    }
}
