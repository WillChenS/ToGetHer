

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
	 
	    
	    String[] hobArray = hobbies.split(",");
	    java.util.Date date = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	    java.sql.Timestamp sqlDT = new java.sql.Timestamp(date.getTime());
	    
	    System.out.println("Variables");
	    Connection c = Database.getCon();
		try {
			c.setAutoCommit(false);
			System.out.println("Connected");
			
			String sql = "INSERT INTO person VALUES (?,?,?,?,?,?,?,?,?,?);";
			
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, ssn);
			ps.setString(2, password);
			ps.setString(3,firstName);
			ps.setString(4,lastName);
			ps.setString(5, addresses[0]);
			ps.setString(6, addresses[1]);
			ps.setString(7, addresses[2]);
			ps.setInt(8, Integer.parseInt(addresses[3]));
			ps.setString(9, email);
			ps.setString(10, phone);
			
			int rowcount = ps.executeUpdate();
			System.out.println("Final insert Statement: \n" + ps);
			System.out.println("Row count affected= " + rowcount);
			
			System.out.println(ssn);
			
			sql = "INSERT INTO user(SSN) VALUES (?)";
			ps = c.prepareStatement(sql);
			ps.setString(1, ssn);
			
			
			rowcount = ps.executeUpdate();
			
			sql = "INSERT INTO Hobbies VALUES(?,?);";
			ps = c.prepareStatement(sql);
			for(String h: hobArray) {
				ps.setString(1, profileID);
				ps.setString(2, h);
				rowcount = ps.executeUpdate();
			}	
			
			
			System.out.println(sql);
			sql = "INSERT INTO account VALUES (?, ?, ?, ?);";
			
			
			ps = c.prepareStatement(sql);
			ps.setString(1,ssn);
			ps.setInt(2, Integer.parseInt(cardNumber));
			ps.setString(3, userName);
			ps.setDate(4, sqlDate);
			
			rowcount = ps.executeUpdate();
			System.out.println("Final insert Statement: \n" + ps);
			System.out.println("Row count affected= " + rowcount);
					
			
			sql = "INSERT INTO profile VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
			
			ps = c.prepareStatement(sql);
			ps.setString(1, profileID);
			ps.setString(2, ssn);
			ps.setInt(3, Integer.parseInt(dRangeMin));
			ps.setInt(4, Integer.parseInt(dRangeMax));
			ps.setInt(5, Integer.parseInt(geoRange));
			ps.setString(6, gender);
			ps.setInt(7, Integer.parseInt(height));
			ps.setInt(8, Integer.parseInt(weight));
			ps.setString(9, hairColor);
			ps.setTimestamp(10, sqlDT);
			ps.setTimestamp(11, sqlDT);
			ps.setInt(12, Integer.parseInt(age));
			System.out.println("Final insert Statement: \n" + ps);
			rowcount = ps.executeUpdate();
			System.out.println("Row count affected= " + rowcount);
			c.commit();
			
			response.sendRedirect("processRegister.jsp");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				c.rollback();
			} catch (SQLException e1) {
				response.sendRedirect("Error.html");
			}
			request.getSession().setAttribute("Msg", "Some value was wrong. Please try again");
			response.sendRedirect("Register.jsp");
		
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
