

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RegisterEmployeeServlet
 */
@WebServlet("/RegisterEmployeeServlet")
public class RegisterEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Opened");
	    String password = request.getParameter("password");
	    String ssn = request.getParameter("SSN");
	    String firstName = request.getParameter("firstName");
	    String lastName = request.getParameter("lastName");
	    String[] addresses = request.getParameterValues("address");  
	    String email = request.getParameter("email");
	    String phone = request.getParameter("phoneNumber");
	    String role = request.getParameter("role");
	    String hourlyrate = request.getParameter("hourlyrate");
	 
	    
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		String updateTime = dtf.format(LocalDateTime.now());
	    
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
			
			ps.executeUpdate();
			
			sql = "INSERT INTO Employee(SSN) VALUES (?)";
			ps = c.prepareStatement(sql);
			ps.setString(1, ssn);
			ps.executeUpdate();
			

			sql = "INSERT INTO employee VALUES (?, ?, ?, ?);";
			
			
			ps = c.prepareStatement(sql);
			ps.setString(1,ssn);
			ps.setString(2, role);
			ps.setString(3, updateTime);
			ps.setString(4, hourlyrate);
			
			c.commit();
			
			response.sendRedirect("ManagerHome.jsp");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				c.rollback();
			} catch (SQLException e1) {
				response.sendRedirect("Error.html");
			}
			request.getSession().setAttribute("Msg", "Some value was wrong. Please try again");
			response.sendRedirect("RegisterEmployee.jsp");
		
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
