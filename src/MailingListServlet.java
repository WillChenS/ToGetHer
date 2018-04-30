import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MailingListServlet
 */
@WebServlet("/MailingListServlet")
public class MailingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailingListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Database db = new Database();
		Connection c = db.getCon();
		String query = "SELECT DISTINCT P.FirstName,P.LastName,P.Email FROM Person P, Profile Pr WHERE Pr.OwnerSSN = P.SSN ORDER BY LastName";
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(query);
			ArrayList<String>firstNames = new ArrayList<String>();
			ArrayList<String>lastNames = new ArrayList<String>();
			ArrayList<String>emails = new ArrayList<String>();
			while(rs.next()) {
				lastNames.add(rs.getString(2));
				firstNames.add(rs.getString(1));
				emails.add(rs.getString(3));
			}
			request.setAttribute("FIRSTNAME", firstNames);
			request.setAttribute("LASTNAME", lastNames);
			request.setAttribute("ADDRESS", emails);	
			getServletContext().getRequestDispatcher("mailingList.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
