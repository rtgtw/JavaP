package StaticAndFinal;

//Singleton that only allows 5 machines
class CoffeeMachine{
    //members/properties
    private float coffeeQty;
    private float waterQty;
    private float milkQty;
    private float sugarQty;

    static private int count = 0;

    //private reference of coffee machine
    //this has to be static because it will be used by the getInstance
    //method which is also static
    static private CoffeeMachine machine = null;

    public void fillMilk(float qty){
        this.milkQty = qty;
    }

    public void fillWater(float qty){
        this.waterQty = qty;
    }

    public void fillCoffee(float qty){
        this.coffeeQty = qty;
    }

    public void fillSugar(float qty){
        this.sugarQty = qty;
    }

    //constructor
    //Making the constructor private turns in into a singleton
    //meaning you cannot outwardly create a new object
    private CoffeeMachine(){
        System.out.println("Machine 1 activated");
        coffeeQty = 1;
        waterQty = 1;
        milkQty = 1;
        sugarQty = 1;
    }

    //There should be a method to creating a coffee machine
    //should be static since we cannot create an object
    static public CoffeeMachine getInstance(){

        if(machine == null){
            machine = new CoffeeMachine();
            count++;
            return machine;
        }else if(count < 5){
            machine = new CoffeeMachine();
            count++;
            return machine;
        }
        return null;
    }

}


public class SingletonAPI {

    public static void main(String args[]){

        CoffeeMachine m1 = CoffeeMachine.getInstance();
        CoffeeMachine m2 = CoffeeMachine.getInstance();
        CoffeeMachine m3 = CoffeeMachine.getInstance();
        CoffeeMachine m4 = CoffeeMachine.getInstance();
        CoffeeMachine m5 = CoffeeMachine.getInstance();
        CoffeeMachine m6 = CoffeeMachine.getInstance();

        System.out.println("");
        System.out.println("");

        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
        System.out.println(m4);
        System.out.println(m5);
        System.out.println(m6);

    }
}
