package ExceptionHandling;

class NoNegativeException extends Exception{

    //override toString message
    public String toString(){
        return "Cannot have a negative value";
    }
}




public class UserDefinedException {

    public int area(int l, int h) throws Exception{

        try {
            if ((l < 0 || h < 0))
                throw new NoNegativeException();
        }finally{
            System.out.println("Exception thrown to caller, finally block triggered in callee");
        }

        int area = l * h;
        return area;
    }


    public static void main(String args[]){

        UserDefinedException ref = new UserDefinedException();

        try {
            System.out.println(ref.area(4, -5));
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
