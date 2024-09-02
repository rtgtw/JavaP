package Io;
import java.io.*;
//Copy data from one file into another file
//source.txt -> source2.txt
//Write and create a new file source txt
//FileOutput to output source .txt
//FileInput to read from source . txt
//File Output again to output source2.txt


public class CopyingFiles {
    String sourceFilePath = "C:\\Users\\remio\\OneDrive\\Desktop\\source.txt";
    String sourceText = "JAVA LANGUAGE Ja2Va La52nGuAgE \n\nHIHI\n\nHEY HEY";

    //throw it to main
    //Method to take a file path and a string and output a .txt file
    //output the file and return the filePath for another method to use
    public String outputFile() throws Exception{
        //Create file output stream object
        try(FileOutputStream fos = new FileOutputStream(this.sourceFilePath);){
            //Writing to the .txt, just write the full sourceText string
            //turn sourceText string into byte array
            byte sourceTextByteArray[] = this.sourceText.getBytes();

            //pass the sourceText into the .txt file, pass in sourceTextByteArray
            fos.write(sourceTextByteArray);

            //Closes automatically since its try with resource
            System.out.println(".txt file created successfully");
        }
        return sourceFilePath;
    }

    //Create a copy of a file (source.txt) and turn the uppercase to lowercases
    public void copyFileLowercase(String filepath)throws Exception{

        //try-catch block w/ resources and pass in FileInputStream and Output Stream
        //Input the file that was created and pass the file path for inputstream
        //place input stream into a byte array
        //looking at each character, using the byte array, transform uppercases to lowercases with the outputstream

        try(FileInputStream fis = new FileInputStream(filepath);
            FileOutputStream fos = new FileOutputStream(filepath.replace("source.txt","source2.txt"));){

            //First place the bytes from the input stream into a byte array
//            byte inputFile[] = new byte[fis.available()];

            int character;

            //read each character one by one, and transform any uppercase to lowercase, using ascii code + 32
            while((character = fis.read()) != -1){

                if(character >= 65 && character <=90){
                    //write into the new file as lowercase
                    fos.write(character + 32);
                }else{
                    System.out.println(character + " " + (char)character);
                    fos.write(character);
                }

            }

            System.out.println("Copy complete");
        }

    }

    public void mergeCopy(String filepath1, String filepath2, String outputFilepath) throws Exception{
        //Open a file stream for filepath one and pass it into new file
        //Open a file stream for filepath 2 and pass it into new file
        //Create output stream file to pass to
        try(FileInputStream fis1 = new FileInputStream(filepath1);
            FileInputStream fis2 = new FileInputStream(filepath2);
            FileOutputStream fos = new FileOutputStream(outputFilepath)){

            //Open the files one at a time and pass them into a buffer
            //Create buffer array of the appropriate size
            //+1 is so i can add a \n
            byte inputBuffer[] = new byte[fis1.available() + fis2.available() + 2];

            int availability1 = fis1.available();
            int availability2 = fis2.available();
            //pass first filestream into buffer
            fis1.read(inputBuffer);

            //\n
            inputBuffer[availability1] = 10;
            inputBuffer[availability1+1] = 10;
            System.out.print(availability1);

            //pass second filestream into buffer
            fis2.read(inputBuffer,availability1 + 2,  fis2.available() );

            System.out.println("Read both inputs");

            //pass inputBuffer into the output file
            fos.write(inputBuffer);

            System.out.println("Wrote into new file");

        }

    }

    //merege copy sequence input stream
    public void mergeCopySequence(String filepath1, String filepath2, String outputFilepath) throws Exception{


        try(FileInputStream fis1 = new FileInputStream(filepath1);
            FileInputStream fis2 = new FileInputStream(filepath2);
            SequenceInputStream sis = new SequenceInputStream(fis1,fis2);
            FileOutputStream fos = new FileOutputStream(outputFilepath);){

//            //create a buffer
//            byte inputArray[] = new byte[sis.available()];

//            //read the buffer
//            sis.read(inputArray);
            int character;

            while((character = sis.read()) != -1){
                fos.write(character);
            }

//            //pass buffer to output
//            fos.write(inputArray);

            //Outputted
            System.out.println("merged 2 files into a new output");

        }
    }







    public static void main(String args[]){
        CopyingFiles ref1 = new CopyingFiles();
        String filepath = "C:\\Users\\remio\\OneDrive\\Desktop\\";
        try {
//            ref1.copyFileLowercase(ref1.outputFile());
//            ref1.mergeCopy(filepath + "source.txt", filepath + "source2.txt", filepath + "destinationMerge.txt");
            ref1.mergeCopySequence(filepath + "source.txt", filepath + "source2.txt", filepath + "destinationMergeSequence.txt");
        }catch(Exception e){
            System.out.println(e);
        }
    }


}
