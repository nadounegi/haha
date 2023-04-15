package lyons.db;

import java.sql.DriverManager;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DbConn {
  public static Connection getconn(){
    Connection conn = null;
    
    String user = "root";
    String passwd = "muajo0824";
    String url = "jdbc:mysql://localhost:3306/nakameguro";

    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(url,user,passwd);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    catch(ClassNotFoundException e){
      e.printStackTrace();
    }
    return conn;
  }
}
