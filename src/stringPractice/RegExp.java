package stringPractice;

public class RegExp {

    //regular expression practice
    public static void main(String args[]){

        String str1 = "%gS&h!";

        String str2 = "asdasdc@rf";
        String str3 = "8";
        String str5 = "abasdasda@outlook.com";


        System.out.println(str5.matches("[a-zA-Z0-9]{1,16}@[a-zA-Z]{1,16}\\.[a-zA-Z]{3,8}"));

        //System.out.println(str2.matches("[a-zA-Z0-9!@#$%^&*()]{8,16}"));
        //System.out.println(str1.matches("[a-z0-9A-Z!@#$%^&*()][a-z0-9A-Z!@#$%^&*()][a-z0-9A-Z!@#$%^&*()][a-z0-9A-Z!@#$%^&*()][a-z0-9A-Z!@#$%^&*()][a-z0-9A-Z!@#$%^&*()]"));



    }


}
