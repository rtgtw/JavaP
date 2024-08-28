package HcmHdl;
//Iteration 1, pass in attributes / data, output a file
import java.io.*;


public class OutputFile {

    //create a method to create a .dat file
    //we need to pass in business object name, array hold attributes, 2D array holding each line of data
    public void createDatFile(String businessObjectName, String attributes[], String[][]data){
        //filename + filepath, filename is businessobject name
        String filename = "C:\\Users\\\\OneDrive\\Desktop\\" + businessObjectName + ".dat";

        //try w/ resources try/catch block, don't have to specify closing resources, done automatically
        //Create a buffer writer object and pass in filewriter anonymous object, and pass in the filename to write to it
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            //now we can start crafting the .dat file
            //start off by creating the header
            writer.write("METADATA|" + businessObjectName);

            //create a for loop to iterate through the attributes array
            for(int i = 0; i < attributes.length; i++){
                writer.write("|" + attributes[i] );
            }
            writer.newLine();

            //new line, now we can start inserting the userdata
            //We can use a forEach loop to iterate through the 2d array
            //First loop iterates the rows, second loop can iterate the data on each row
            for(String[] row : data){
                //Create the merge statement just like the header
                writer.write("MERGE|" + businessObjectName);
                for(String attribute : row){
                    writer.write("|" + attribute);
                }
                writer.newLine();
            }

        }catch(Exception e){
            System.out.println(e);
        }

        System.out.println("File " + filename + " has been created");
    }


    public static void main(String args[]){
        OutputFile file = new OutputFile();

        String businessObject = "ActionReasons";
        String attributes[] = {"SourceSystemOwner","SourceSystemId","StartDate","ActionReasonCode","ActionReason"};
        String data[][] = {
                {"VICTORYENT","ActionReasons1","2024/01/01","VICTORYAR","VictoryUpdate"},
                {"VICTORYENT","ActionReasons2","2024/01/01","VICTORYAR1","VictoryUpdate1"},
                {"VICTORYENT","ActionReasons3","2024/01/01","VICTORYAR33","VictoryUpdate3"}
        };

        file.createDatFile(businessObject,attributes,data);


    }






}
