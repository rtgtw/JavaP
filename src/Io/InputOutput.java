package Io;
import java.io.*;


//You can turn a byte array into a string
public class InputOutput {

    public static void main(String args[]) throws Exception {


        //Byte output stream creates a byte array
        ByteArrayOutputStream bos = new ByteArrayOutputStream(20);

        bos.write('a');
        bos.write('b');
        bos.write('c');
        bos.write('d');

        bos.writeTo(new FileOutputStream("C:\\Users\\remio\\OneDrive\\Desktop\\testing123.txt"));
        System.out.println("Success");

//        byte b[] = bos.toByteArray();
//
//        for(byte x : b){
//            System.out.println( (char)x);
//        }

        bos.close();







//        //Byte array input stream
//        byte b[] = {'a', 'b', 'c', 'd',' '};
//
//        ByteArrayInputStream bis = new ByteArrayInputStream(b);
//
//        String str = new String(bis.readAllBytes());
//
//        System.out.println(str);
//
//        bis.close();


    }
}
