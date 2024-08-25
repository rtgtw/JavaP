package AbstractClasses;

 abstract class Hospital {

    Hospital(){
        System.out.println("This is a hospital");
    }

    abstract void emergency();
    abstract void billing();
    abstract void admit();
    abstract void appointment();



}

class MyHospital extends Hospital{

    MyHospital(){
        System.out.println("This is my hospital!");
    }

     void emergency(){
        System.out.println("MyHospital is handling an emergency!");
     };
     void billing(){
         System.out.println("MyHospital is handling the billing!");
     };
     void admit(){
         System.out.println("MyHospital is handling the admission");
     };
     void appointment(){
         System.out.println("MyHospital is handling the appointments!");
     };

}

public class HospitalAPI{

     public static void main(String args[]){

         //Dynamic method dispatch
         //The hospital abstract class will use the MyHospital object
         Hospital h = new MyHospital();

         h.admit();
         h.appointment();
         h.billing();
         h.emergency();
     }

}
