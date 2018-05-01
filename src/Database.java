import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	String hostName = "mysql4.cs.stonybrook.edu";
	String dbName = "bchowdhury";
	String username = "bchowdhury";
	String password = "110817284";
	
	public static Connection getCon() throws SQLException, ClassNotFoundException {
		Connection conn;
		String hostName = "mysql4.cs.stonybrook.edu";
		String dbName = "bchowdhury";
		String username = "bchowdhury";
		String password = "110817284";
		
		Class.forName("com.mysql.jdbc.Driver");
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		conn = DriverManager.getConnection(connectionURL,username,password);
		return conn;
		
	}
}
