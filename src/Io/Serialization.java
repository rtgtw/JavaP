package Io;
import java.io.*;

class Student implements Serializable{
    private int studentid;
    private String name;
    private float average;
    private String dept;
    public transient int date;

    Student(){

    }

    Student(int studentid, String name, float average, String dept){
        this.studentid = studentid;
        this.name = name;
        this.average = average;
        this.dept = dept;
        date = 500;

    }

}


public class Serialization {

    public static void main(String args[]) throws Exception{

        FileOutputStream fos = new FileOutputStream("C:\\Users\\remio\\OneDrive\\Desktop\\file123.txt");

        //Create an object of ObjectOutputStream
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Student s = new Student(1,"john",2.22f,"Science");

        oos.writeObject(s);

        fos.close();
        oos.close();

    }
}
