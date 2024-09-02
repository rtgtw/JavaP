package Io;
import java.io.*;
//Use fileoutput stream to write a .txt file
//Use fileinputstream to read the data
//File reader/writer

public class OutputStream {
    public static void main(String args[]){

       try {
           //Reading from a file
//           try (FileInputStream fis = new FileInputStream("C:\\Users\\remio\\OneDrive\\Desktop\\Test.txt")) {
           //file reader reads 2 bytes at atime, takes a character
           try (FileReader fr = new FileReader("C:\\Users\\remio\\OneDrive\\Desktop\\Test.txt")) {

               int x;

               while((x = fr.read()) != -1){

                   System.out.print(x + " - ");
                   System.out.println((char)x);
               }












             /*  //Create a bytes array, size of the bytes array should be equal to the size of the file content
               //we want to use the available method, returns how many bytes are within the file
               byte b[] = new byte[fis.available()];
               fis.read(b);

               //Convert the byte array into a string
               String byteString = new String(b);
               System.out.println(byteString);*/

                //read bytes from a file letter by letter
//               int x;
//
//               System.out.println("ASCII CODES");
//               do{
//                   //returns -1 when file ends
//                   x = fis.read();
//                   //you have to type cast it as a char since you are going to get an integer value
//
//                   //if statement not to include the -1, make it out of the condition
//                   if(x != -1) {
//                       System.out.print(x + " - ");
//                       System.out.println((char) x);
//                   }
//               }while(x != -1);
//               //Can also just us a while loop, this is good for learning purposes


           }
       }catch(IOException e){
           System.out.println(e);
       }

















//        //Create an object of fileoutput stream
//        //Mention the path where you want to store the file
//        try {
//            try (FileOutputStream fos = new FileOutputStream("C:\\Users\\remio\\OneDrive\\Desktop\\Test2.txt")) {
//                String str = "Learn Java Programming";
//                byte b[] = str.getBytes();
//
//
//                fos.write(b);
//
//            }
//
//        }catch(FileNotFoundException e){
//            System.out.println("File not found " + e);
//        }catch(IOException e){
//            System.out.print(e);
//        }


    }
}
