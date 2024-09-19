
    import java.sql.*;
import java.util.Scanner;

    public class preparedStat {
        public static void main(String[] args){
        String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
        String USER = "SYSTEM";
        String PASSWORD= "BCA5C";
        //step 1: Register the driver class
        try
        {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        //step 2: open DB connection
        Connection con= DriverManager.getConnection(DB_URL, USER, PASSWORD);
        if(con != null)
        {
            System.out.println("connected to oracle");
        }
        else{
            System.out.println("failed to connect");
        }

        //step 3: create the prepared statement 
      
        String insertsql = "Insert into Student1 values(?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(insertsql);
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter student details or type Q to quit");
        while(! "Q".equals(scan.next()))
        {
            //Step 4: Execute Statement
            System.out.println("Enter student sid");
            int sid = scan.nextInt();
            System.out.println("Enter student name");
            String sname = scan.next();
            System.out.println("Enter Student city");
            String city = scan.next();
            pstmt.setInt(1, 13);
            pstmt.setString(2, "Rajat");
            pstmt.setString(3, "Bangalore");
            int r = pstmt.executeUpdate();
            System.out.println(r);
            System.out.println("Student entered succesfully. Do u want to continue?");
        }

        
        //step 5: close connection
        con.close();
    
}
 
catch(ClassNotFoundException e)
{
    e.printStackTrace();
}
catch(Exception e){
    e.printStackTrace();
}

    


            }    
}
