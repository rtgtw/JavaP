package JavaLang;
import java.lang.*;


//Use the @ sign to make an interface a user-defined annotation
//Inherits from java.lang.annotation.Annotation class
//Annotations define metadata for a class or methods or anything
//Annotations can be used at class level, method level, parameters, local var
//instance variable
//abstract methods = elements of annotation

@interface MyAnnotation{

    String name();

}

//class level
@MyAnnotation(name = "bob")
public class UserAnnotations {

    //Method level
    @MyAnnotation(name = "bob")
    public static void main(String args[]){

    }
}
