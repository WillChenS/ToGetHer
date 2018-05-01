

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Opened");
		String userName = request.getParameter("userName");
	    String password = request.getParameter("password");
	    String ssn = request.getParameter("SSN");
	    String cardNumber = request.getParameter("cardNumber");
	    String firstName = request.getParameter("firstName");
	    String lastName = request.getParameter("lastName");
	    String gender = request.getParameter("gender");	
	    String[] addresses = request.getParameterValues("address");  
	    String email = request.getParameter("email");
	    String phone = request.getParameter("phoneNumber");
	    String profileID = request.getParameter("profileID");
	    String age = request.getParameter("age");
	    String dRangeMin = request.getParameter("dRangeMin");
	    String dRangeMax = request.getParameter("dRangeMax");
	    String geoRange = request.getParameter("geoRange");
	    String height = request.getParameter("height");
	    String weight = request.getParameter("weight");
	    String hairColor = request.getParameter("hairColor");
	    String hobbies = request.getParameter("hobbies");
	 
	    
	    String[] hobArray = hobbies.split(" ");
	    java.util.Date date = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	    java.sql.Timestamp sqlDT = new java.sql.Timestamp(date.getTime());
	    
	    System.out.println("Variables");
	    
		try {
			Connection c = Database.getCon();
			System.out.println("Connected");
			String sql = "INSERT INTO (account,person,profile) VALUES (?, ?, ?, ?),(?, ?, ?, ?),(?, ?, ?, ?)";
			
			for(String h: hobArray) {
				sql = sql + "INSERT INTO Hobbies VALUES('" + profileID + "','" + h + "'); \n";	
			}
			System.out.println(sql);
			
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1,ssn);
			ps.setInt(2, Integer.parseInt(cardNumber));
			ps.setString(3, userName);
			ps.setDate(4, sqlDate);
			ps.setString(5, ssn);
			ps.setString(6, password);
			ps.setString(7,firstName);
			ps.setString(8,lastName);
			ps.setString(9, addresses[0]);
			ps.setString(10, addresses[1]);
			ps.setString(11, addresses[2]);
			ps.setInt(12, Integer.parseInt(addresses[3]));
			ps.setString(13, email);
			ps.setString(14, phone);
			ps.setString(15, profileID);
			ps.setString(16, ssn);
			ps.setInt(17, Integer.parseInt(dRangeMin));
			ps.setInt(18, Integer.parseInt(dRangeMax));
			ps.setInt(19, Integer.parseInt(geoRange));
			ps.setString(20, gender);
			ps.setInt(21, Integer.parseInt(height));
			ps.setInt(22, Integer.parseInt(weight));
			ps.setString(23, hairColor);
			ps.setTimestamp(24, sqlDT);
			ps.setTimestamp(25, sqlDT);
			ps.setInt(26, Integer.parseInt(age));
			System.out.println("Final insert Statement: \n" + ps);
			int rowcount = ps.executeUpdate();
			System.out.println("Row count affected= " + rowcount);
			response.sendRedirect("processRegister.jsp");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			response.sendRedirect("loginfail.html");
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
