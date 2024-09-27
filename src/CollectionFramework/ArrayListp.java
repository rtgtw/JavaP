package CollectionFramework;
import java.util.*;
public class ArrayListp {






    public static void main(String args[]){
        ArrayList<Integer> al1 = new ArrayList<>(20);
        ArrayList<Integer> al2 = new ArrayList<>(List.of(50,60,70,80,90));
        al1.add(10);
        al1.add(0,5);
        al1.addAll(1,al2);
        al1.indexOf(50);


        for(int i = 0; i < al1.size(); i++){
            System.out.println(al1.get(i));
        }

        for(var x : al1){
            System.out.println(x);
        }

        ListIterator<Integer> it = al1.listIterator();

        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }




    }



}
