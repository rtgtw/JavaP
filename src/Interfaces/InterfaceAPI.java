package Interfaces;

//an interface has all abstract methods
interface TestInterface{
    void method1();
    void method2();
}

class MyClass implements TestInterface{

    public void method1(){
        System.out.println("Method1 of MyClass");
    }

    public void method2(){
        System.out.println("Method2 of Myclass");
    }

    public void method3(){
        System.out.println("Method3 of MyClass");
    }


}


public class InterfaceAPI {
    public static void main(String args[]){

        //A reference of an interface can hold a class
        TestInterface t = new MyClass();
    }
}
