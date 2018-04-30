import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	Connection conn;
	String hostName = "mysql4.cs.stonybrook.edu";
	String dbName = "wschen";
	String username = "wschen";
	String password = "111062517";
	
	public Connection getCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
			conn = DriverManager.getConnection(connectionURL,username,password);
			return conn;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			return conn;
		}
	}
}
