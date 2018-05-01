import java.sql.Connection;

public class conTest {
	
	public static void main(String[] args) {
	try {
	System.out.println("Connecting....");
	Connection c =Database.getCon();
	System.out.println(c);
	System.out.println("Done!!");
	}catch(Exception e) {
		e.printStackTrace();
	}
	}

}
