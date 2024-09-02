package Io;
import java.io.*;
//Use fileoutput stream to write a .txt file
//Use fileinputstream to read the data
//File reader/writer

public class OutputStream {
    public static void main(String args[]){
//        //Create an object of fileoutput stream
//        //Mention the path where you want to store the file
//        try {
//            FileOutputStream fos = new FileOutputStream("C:\\Users\\remio\\OneDrive\\Desktop\\Test2.txt");
//            String str = "Learn Java Programming";
//            byte b[] = str.getBytes();
//
//
//                fos.write(b,6,str.length()-6);
//
//            fos.close();
//
//        }catch(FileNotFoundException e){
//            System.out.println("File not found " + e);
//        }catch(IOException e){
//            System.out.print(e);
//        }


        //Create an object of fileoutput stream
        //Mention the path where you want to store the file
        try {
            try (FileOutputStream fos = new FileOutputStream("C:\\Users\\remio\\OneDrive\\Desktop\\Test2.txt")) {
                String str = "Learn Java Programming";
                byte b[] = str.getBytes();


                fos.write(b);

            }

        }catch(FileNotFoundException e){
            System.out.println("File not found " + e);
        }catch(IOException e){
            System.out.print(e);
        }


    }
}
