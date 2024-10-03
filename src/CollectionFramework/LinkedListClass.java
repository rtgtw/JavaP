package CollectionFramework;


import java.util.ArrayList;
import java.util.List;

//java uses doubly linked list, theres also a singly link list as well
public class LinkedListClass {


    public static void main(String args[]){

        ArrayList<Integer> al1 = new ArrayList<Integer>(20);
        ArrayList<Integer> al2 = new ArrayList<Integer>(List.of(50,60,70,80,90));

        al1.add(10);
        al1.add(0,5);
        al1.addAll(1,al2);
        al1.add(5,70);

        al1.set(6,100);

        al1.forEach(n ->show(n));

    }

    static void show(int n){

        if(n > 60){
            System.out.println(n);
        }
    }
}
