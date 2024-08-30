package Lambda;


//if an interface has a single abstract method then its a functional interface
@FunctionalInterface
interface MyLambda{
    public void display(String str);
}

interface MyLambda2{
    public int add(int x , int y);
}


//class MyClass implements MyLambda{
//    public void display(){
//        System.out.println("Hello World");
//    }
//}


public class Lambda {
    public static void main(String args[]) {

//        //Can use a reference of the interface since it is being implemented by the class
//        MyClass ref1 = new MyClass();
//        MyLambda ref2 = new MyClass();
//        ref2.display();
        //We can define an anonymous inner class

//        MyLambda ref1 = new MyLambda(){
//            public void display(){
//                System.out.println("Hello World");
//            }
//        };


        //Lambda function
        //Method itself is an object, anonymous method acting as an object
        MyLambda ref2 = (t)->{System.out.println("Hello " + t);};


        ref2.display("Bob");



        MyLambda2 ref3 =(a,b)->a+b;
        System.out.println(ref3.add(1,2));



    }
}
