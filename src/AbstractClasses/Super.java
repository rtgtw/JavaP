package AbstractClasses;

abstract class Super {

    //constructor
    Super(){
        System.out.println("Hello from super");
    }

    //regular method within parent class
    void method1(){
        System.out.println("Super method 1");
    }

    //abstract method within parent class
    abstract void method2();
}


class Sub extends Super{

    //constructor
    Sub(){
        System.out.println("Hello from sub class");
    }

    //Overriding method 1 from parent class
    void method1(){
        System.out.println("Method 1 from sub class");
    }

    //defining method2 which was abstract from parent class
    void method2(){
        System.out.println("Method 2 from sub class");
    }

    void method3(){
        System.out.println("Method 3 from sub class");
    }
}



class Main{

    public static void main(String args[]){


        //Dynamic Method Dispatch
        //Creating an instance(object) of sub from Super class reference
        //only will be able to use methods that are apart of Super class
        Super super1 = new Sub();
        super1.method2();

        //this is an error because Super class does not have method3
        //only has methods 1 and 2
        //super1.method3();


        Sub sub1 = new Sub();
        sub1.method2();
        sub1.method3();
    };
}

