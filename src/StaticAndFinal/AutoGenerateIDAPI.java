package StaticAndFinal;


//To create a counter that will be available(metadata) to all the objects
//in the class we can use  static, and make it private as well


import java.util.Date;

class Student{

    private String name;
    private String studentID;
    private static int counter = 1;

    private String generateStudentID(){
        //Create an object of class date
        Date d = new Date();
        String studentID = "Univ-" + (d.getYear() + 1900) + "-" + counter;
        counter++;
        return studentID;
    }

    public Student(String name){
        this.name = name;
        studentID = this.generateStudentID();
    }

    public void getDetails(){
        System.out.println(this.name + "'s StudentID is: " + this.studentID);
    }
}

public class AutoGenerateIDAPI {

    public static void main(String args[]){

        Student s1 = new Student("John");
        Student s2 = new Student("Billy");
        Student s3 = new Student("Gabe");

        s1.getDetails();
        s2.getDetails();
        s3.getDetails();
    }
}
