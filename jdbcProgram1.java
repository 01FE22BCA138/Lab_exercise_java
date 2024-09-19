
    import java.sql.*;

public class jdbcProgram1{
    public static void main(String[] args){
        String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
        String USER = "SYSTEM";
        String PASSWORD= "BCA5C";
        //step 1: Registerr the driver class
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

        //step 3: create the statement 
        Statement stmt = con.createStatement();

       //Step 4: execute the statement
        String sql = "Create table Student1(sid int primary key, sname varchar(20), city varchar(20))";
        //int r = stmt.executeUpdate(sql);
        String insertsql = "Insert into Student1 values(138, 'Sukanya', 'Hubli' )";
        //int r = stmt.executeUpdate(insertsql);
        //boolean success = stmt.execute(insertsql);
        //ResultSet rs = stmt.executeQuery(insertsql);
        String selectsql = "select * from Student1";
        boolean success = stmt.execute(selectsql);
        int r = stmt.executeUpdate(selectsql);
        ResultSet rs = stmt.executeQuery(selectsql);
        System.out.println(r);
        System.out.println(success);
        System.out.println(rs);
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " ");
            System.out.println(rs.getInt("sid") + " " + rs.getString("sname") + " " + rs.getString("city") + " ");
        }
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
    

