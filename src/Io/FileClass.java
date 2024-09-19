package Io;

import java.io.*;

public class FileClass {


    public static void main(String args[]) throws Exception{

        File f= new File("C:\\Users\\remio\\OneDrive\\Desktop\\myjava");

        System.out.println(f.isDirectory());

        //Gives an array of strings
        String files[] = f.list();

        for(String x : files){
            System.out.println(x);
        }

        //ListFiles returns an array of files
        File arrayFiles [] = f.listFiles();

        for(File x : arrayFiles){

            System.out.println(x.getName());
        }


    }
}
