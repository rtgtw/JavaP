package Interfaces;

//This smart phone will extend from a phone class
//This smart phone will also have two interfaces, musicplayer and camera
//We will take references of the smartphone to use the full smartphone functionality
//which stems from methods within the smart phone, phone class, music player and camera
//We will also take a reference of a phone using the smartphone objec
//a reference of the music player, and camera as well using the same smartphone object

//Create the phone class which will be the parent class smartphone will extend from
class Phone{

    void makeCall(){
        System.out.println("Phone making a call");
    }

    void sendSMS(){
        System.out.println("Phone sending a text message");
    }
}

//Create camera interface which will define abstract methods
//a class can have multiple interfaces but only extend from only 1 parent class
//an interface consists of all abstract methods
interface ICamera{

    void click();
   public void record();
}

//Create music player interface which will define abstract methods
interface IMusicPlayer{
    void play();
    void pause();
    void stop();
}

//Create a smartphone class which will extend from the phone class and implement
//both the camera interface and the music player interface
//This smartphone has everything from the parent class (Phone)
//but also needs to define the abstract methods found in both interfaces
//and also create its own methods found within the smartphone
class Smartphone extends Phone implements ICamera, IMusicPlayer{

    //Take different references for the same Smartphone object
    //Only have one smartphone object availalble, cannot create multiple
    private static final Smartphone smartphoneInstance = new Smartphone();

    //Constructor
    private Smartphone(){
        System.out.println("Initializing SmartPhone");
    }

    void internetAccess(){
        System.out.println("Browse the internet w/ smartphone");
    }

    //Override sendSMS from parent class
    @Override
    void sendSMS(){
        System.out.println("Send SMS Smartphone style");
    }

    //Define interface methods
    public void click(){
        System.out.println("Take Photo");
    }

    public void record(){
        System.out.println("Recording...");
    };

    public void play(){
        System.out.println("Playing Music...");
    };
    public void pause(){
        System.out.println("Pausing Music Player...");
    };
    public void stop(){
        System.out.println("Stopping Music Player");
    };

    //Get the smartphone object
    //returns smartphone object
    //only way to get ahold of the single smartphone instance(object)
    public static Smartphone getInstance(){
        return smartphoneInstance;
    }
}




public class SmartPhoneAPI {

    public static void main(String args[]){

        //Get the smartphone instance
        Smartphone smartphone = Smartphone.getInstance();

        //Smartphone
        smartphone.internetAccess();
        smartphone.click();

        System.out.println("");
        System.out.println("");


        //Phone
        Phone phone1 = smartphone;
        phone1.makeCall();

        System.out.println("");
        System.out.println("");

        //Camera
        ICamera camera1 = smartphone;
        camera1.click();
        camera1.record();

        System.out.println("");
        System.out.println("");

        //Music Player
        IMusicPlayer musicPlayer = smartphone;
        musicPlayer.pause();
        musicPlayer.play();

        //Not legal since constructor is private
//        Smartphone smartphone1 = new Smartphone();

    }
}
