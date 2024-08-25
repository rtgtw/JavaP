package Bari;

 class Animal{

    //property
    public String name;
    private int age;

    Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

}

 class Dog extends Animal{

        private int legs;

        Dog(String name, int age, int legs){
          super(name, age);
          this.legs = legs;
        }

        private void setLegs(int legNumber){
            this.legs = legNumber;
        }

        private void getLegs(){
            System.out.println("Number of legs: " + legs);
        }

        private void details(){
            System.out.println("Name: " + this.getName() + " age " + this.getAge() + " Number of legs: " + this.legs);
        }

        public void passwordForDetails(String password){
            if(password != null) {
                if (password.equals("details")) {
                    this.details();
                } else {
                    System.out.println("WRONG PASSWORD");
                }
            }else{
                System.out.println("Error. Null is not allowed");
            }
        }

}


public class ParentChildConstructor {

    public static void main(String args[]){

        Dog d1 = new Dog("Buddy",43, 4);

        d1.passwordForDetails(null);

    }


}
