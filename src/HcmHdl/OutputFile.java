package HcmHdl;
//Iteration 1, pass in attributes / data, output a file
//Iteration 2, convert .dat file into .zip file
import java.io.*;
import java.util.zip.*;


public class OutputFile {

    //create a method to create a .dat file
    //we need to pass in business object name, array hold attributes, 2D array holding each line of data
    public void createDatFile(String businessObjectName, String attributes[], String[][]data){
        //filename + filepath, filename is businessobject name
        String filename = businessObjectName + ".dat";
        String filepath = "C:\\Users\\\\OneDrive\\Desktop\\" + filename ;

        //try w/ resources try/catch block, don't have to specify closing resources, done automatically
        //Create a buffer writer object and pass in filewriter anonymous object, and pass in the filename to write to it
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))){
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


        this.zipDatFile(filename,filepath);
    }


    public void zipDatFile(String datFilename, String datFilepath){
        //replace .dat with .zip
        String zipFilename = datFilename.replace(".dat",".zip");
        String zipFilepath = "C:\\Users\\\\OneDrive\\Desktop\\" + zipFilename;

        try(
                FileInputStream fis = new FileInputStream(datFilepath);
                FileOutputStream fos = new FileOutputStream(zipFilepath);
                ZipOutputStream zos = new ZipOutputStream(fos);
                ){

            //Create a zipEntry with the datFile
            ZipEntry zipentry = new ZipEntry(datFilename);
            zos.putNextEntry(zipentry);


            //Create reading buffer
            byte[] buffer = new byte[1024];
            int length;

            //Read the dat file and write it to the zip
            while((length = fis.read(buffer)) > 0){
                zos.write(buffer,0,length);
            }

            //close the zipentry (dat file)
            zos.closeEntry();
            System.out.println("File " + zipFilename + " was created");

        }catch(Exception e){
            System.out.println(e);
        }
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
