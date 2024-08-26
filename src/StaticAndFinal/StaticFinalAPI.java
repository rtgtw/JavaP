package StaticAndFinal;

//Static blocks

class Blocks{

    static{
        System.out.println("Static Block 1");
    }

    static{
        System.out.println("Static Block 2");
    }
}

public class StaticFinalAPI {
    public static void main(String args[]){
        Blocks block1 = new Blocks();
    }

}
