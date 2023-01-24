package Employee;
import java.sql.*;
public class Databaseconn {
    public Connection c;
    public Statement s;
    public Databaseconn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///employee","root","");
            s=c.createStatement();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
