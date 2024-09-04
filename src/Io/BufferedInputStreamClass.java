package Io;
import java.io.*;



//Within buffered input stream you can mark an index and loop through it
//cannot do this with files which only go forward
//buffered is an array
class BufferedInputStreamClass{

    public static void main(String args[]) throws Exception {
        //Create an object of the file and open the file
        FileInputStream fis = new FileInputStream("C:\\Users\\remio\\OneDrive\\Desktop\\testing123.txt");

        //Create a buffered input stream and attach a file / fileinput stream
        BufferedInputStream bis = new BufferedInputStream(fis);

        //Mark within buffered inputStream

        System.out.print((char) bis.read());
        bis.mark(3);
        System.out.print((char) bis.read());
        System.out.print((char) bis.read());
        System.out.print((char) bis.read());
        System.out.print((char) bis.read());
        bis.reset();
        System.out.print((char) bis.read());
        System.out.print((char) bis.read());
        System.out.print((char) bis.read());


    }
}




