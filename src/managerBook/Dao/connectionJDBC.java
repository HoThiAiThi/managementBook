
package managerBook.Dao;
import java.sql.*;

public class connectionJDBC {
    public static Connection connectionJDBC(){
        final String URL = "jdbc:sqlserver://localhost;database=Manager_Book";
        final String USER = "sa";
        final String PASS = "051202";
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(URL, USER, PASS);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
    