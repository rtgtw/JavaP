package ExceptionHandling;

public class ThrowThrowsException {

    int length =5;
    int bwidth = -2;


    //Caller should handle the exception
    public int method3(int length, int width) throws Exception{

        //Throw an exception if this method receives a negative value
        if(length < 0 || width < 0){
            //create new Exception object, pass in string message
            throw new Exception("Should not pass in negative value");
        }
         int height = length * width;
         return height;

    }

    //if i did not write the try catch here then i can also throws method2 and have the main
    //message catch it,
    public void method2(int length, int width)throws Exception{


            System.out.println(this.method3(length,width ));


    }

    public static void main(String args[])throws Exception{
        ThrowThrowsException ref = new ThrowThrowsException();
        ref.method2(1,-5);
    }


}
