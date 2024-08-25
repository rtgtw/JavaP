package Bari;

public class Practice {

    static void change(int Array[],int index, int value){

        Array[index] = value;
    }

    static void change(float Array[],int index, float value){

        Array[index] = value;
    }

    public static void main(String args[]){

        int array1[] = {1,2,3,4,5};
        float array2[] = {1,2,3,4,5};

        change(array1,4,1999);

        for(int i = 0; i < array1.length; i++){

            System.out.println("Index " + i + " value: " + array1[i]);
        }


        change(array2,2,5);

        for(int i = 0; i < array2.length; i++){

            System.out.println(array2[i]);
        }
    }



}
