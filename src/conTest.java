import java.sql.Connection;

public class conTest {
	
	public static void main(String[] args) {
	Database db = new Database();
	Connection c = db.getCon();
	System.out.println(c);
}

}
