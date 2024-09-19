import java.sql.*;
import java.util.Scanner;
public class ScrollableResultSet{
public static void main(String[] args) {
    String DB_URL="jdbc:oracle:thin:@localhost:1521:xe";
    String user="SYSTEM";
    String password="BCA5C";
    try{
       Class.forName("oracle.jdbc.driver.OracleDriver");
       Connection con=DriverManager.getConnection(DB_URL, user, password);
       if(con!=null){
        System.out.println("Connetion successful to Oracle DB");
       }
       else{
        System.out.println("Connection Failed");
       }
     
        Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=stmt.executeQuery("select * from Student1");
        System.out.println(rs);
         System.out.println("Move Forward");
         while(rs.next()){
          System.out.println("Printing Student data in forward direction");
          System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
         }
         System.out.println("Move Backward");
         rs.last();
         while(rs.previous()){
          System.out.println("Printing student data in backward direction");
          System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));

         }

         rs.absolute(2);
         System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
         con.close();

        }
    catch(ClassNotFoundException e){
           e.printStackTrace();
    }
    catch(SQLException s){
            s.printStackTrace();
    }

}

}