

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
		Database db = new Database();
		Connection c = db.getCon();
		PreparedStatement ps = null;
		String nextPage = null;
		String query = "SELECT P.Password FROM Profile Pr, Person P WHERE Pr.ProfileID = ? AND Pr.OwnerSSN = P.SSN AND P.Password = ?";
		try {
			ps = c.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			String enteredPW = null;
			while (rs.next()) {
				enteredPW = rs.getString(1);
			}
			if (enteredPW == null) nextPage = "loginfail.html";
			else nextPage = "Home.html";
			response.sendRedirect(nextPage);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
