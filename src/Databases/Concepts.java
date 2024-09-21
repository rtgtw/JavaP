package Databases;

import java.sql.*;


public class Concepts {

    public void sqlQuery(int ID){
        String hostname = "localhost";
        String port = "1521";
        String serviceName = "XEPDB1";
        String username = "hr";
        String p = "hr";

        String jdbcUrl = "jdbc:oracle:thin:@" + hostname + ":" + port + "/" + serviceName;

        Connection con = null;

        //try catch block
        try{
            //load jdbc driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //Establish the connection
            con = DriverManager.getConnection(jdbcUrl,username,p);
            System.out.println("Connected");

            //Create a statement
            Statement statement = con.createStatement();

            //Execute query
            String sql = "select  first_name as FirstName,last_name, salary, hire_date  from employees where employee_id= " + ID;
            //Store in the resultset
            ResultSet resultSet = statement.executeQuery(sql);

            //get the resultset metadata
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();


            System.out.println("---------Table Data----------");
            for(int i = 1; i <= columnCount; i++){
                System.out.print(rsmd.getColumnName(i) + "\t");
            }

            System.out.println();

//            for(int i = 1; i <= columnCount; i++){
//                System.out.print("---------- \t");
//            }

            //print result set
            while(resultSet.next()){
                for(int i = 1; i <= columnCount; i++){
                    String value = resultSet.getString(i);
                    System.out.print(value + "\t");
                }
                System.out.println();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void sqlQuery2Insert(int salary, int id){
        String hostname = "localhost";
        String port = "1521";
        String serviceName = "XEPDB1";
        String username = "hr";
        String password = "hr";

        String jdbcUrl = "jdbc:oracle:thin:@" + hostname + ":" + port + "/" + serviceName;

        Connection con = null;

        //try catch block
        try{
            //load jdbc driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //Establish the connection
            con = DriverManager.getConnection(jdbcUrl,username,password);
            System.out.println("Connected");

            //Create a statement
            Statement statement = con.createStatement();

            //Execute query
            String sql = "update employees set salary =  "+ salary + " where employee_id= " + id ;
            //Store in the resultset
            statement.executeQuery(sql);

            String sql2 = "rollback";

            statement.executeQuery(sql2);



//            //get the resultset metadata
//            ResultSetMetaData rsmd = getMetaData();
//            int columnCount = rsmd.getColumnCount();


//            System.out.println("---------Table Data----------");
//            for(int i = 1; i <= columnCount; i++){
//                System.out.print(rsmd.getColumnName(i) + "\t");
//            }

            System.out.println();

//            for(int i = 1; i <= columnCount; i++){
//                System.out.print("---------- \t");
//            }

//            //print result set
//            while(resultSet.next()){
//                for(int i = 1; i <= columnCount; i++){
//                    String value = resultSet.getString(i);
//                    System.out.print(value + "\t");
//                }
//                System.out.println("Salary Updated");
//            }

            System.out.println("Salary Updated");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void sqlQuery3(){
        String hostname = "localhost";
        String port = "1521";
        String serviceName = "XEPDB1";
        String username = "hr";
        String password = "hr";

        String jdbcUrl = "jdbc:oracle:thin:@" + hostname + ":" + port + "/" + serviceName;

        Connection con = null;

        //try catch block
        try {
            //load jdbc driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //Establish the connection
            con = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected");

            //Create a statement
            Statement statement = con.createStatement();

            //Execute query
            String sql = "rollback";
            //Store in the resultset
            statement.executeQuery(sql);
            System.out.println("Rolled back");
        }catch(Exception e){
            System.out.println(e);
        }
    };



    public static void main(String args[]){

        Concepts query = new Concepts();
//        query.sqlQuery2Insert(2220,131);
        query.sqlQuery(131);
//        query.sqlQuery3();





    }
}


