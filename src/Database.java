import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	String hostName = "mysql4.cs.stonybrook.edu";
	String dbName = "bchowdhury";
	String username = "bchowdhury";
	String password = "110817284";
	
	public static Connection getCon() {
		Connection conn;
		String hostName = "mysql4.cs.stonybrook.edu";
		String dbName = "bchowdhury";
		String username = "bchowdhury";
		String password = "110817284";
		
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(connectionURL,username,password);
		return conn;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
