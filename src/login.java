

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     *
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		Connection c = Database.getCon();
		
		try {
		PreparedStatement ps = null;
		String nextPage = null;
		String query = "SELECT P.Password FROM Profile PR, Person P WHERE PR.ProfileID = ? AND PR.OwnerSSN = P.SSN AND P.Password = ?";
		
		ps = c.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			String userPW = null;
			while (rs.next()) {
				userPW = rs.getString(1);
			}
			if (userPW == null) {
				query = "SELECT E.Role FROM Employee E, Person P WHERE E.SSN = ? AND E.SSN = P.SSN AND P.Password = ?";
				ps = c.prepareStatement(query);
				ps.setString(1,uname);
				ps.setString(2, pass);
				rs = ps.executeQuery();
				String empRole = null;
				while (rs.next()) {
					empRole = rs.getString(1);
				}
				if (empRole == null) {
					nextPage = "loginfail.jsp";
				}
				else {
					if (empRole.equals("Manager")) {
						nextPage = "ManagerHome.jsp";
						request.getSession().setAttribute("Role","Manager");
						request.getSession().setAttribute("ID", uname);
						response.sendRedirect(nextPage);
					}
					else {
						nextPage = "CustRepHome.jsp";
						request.getSession().setAttribute("Role","Employee");
						request.getSession().setAttribute("ID", uname);
						response.sendRedirect(nextPage);
					}
				}
			}
			else {
				nextPage = "UserHome.jsp";
				request.getSession().setAttribute("Role","Customer");
				request.getSession().setAttribute("ID", uname);
				response.sendRedirect(nextPage);
			}
			//response.sendRedirect(nextPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
