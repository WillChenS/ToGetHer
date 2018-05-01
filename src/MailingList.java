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
@WebServlet("/MailingList")
public class MailingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailingList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection c = Database.getCon();
		String query = "SELECT DISTINCT P.FirstName,P.LastName,P.Email FROM Person P, Profile Pr WHERE Pr.OwnerSSN = P.SSN ORDER BY LastName";
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(query);
			ArrayList<MailingInfo>listing = new ArrayList<MailingInfo>();
			while(rs.next()) {
				MailingInfo inf = new MailingInfo(rs.getString(2),rs.getString(1),rs.getString(3));
				listing.add(inf);
			}
			request.setAttribute("MailingList",listing);
			getServletContext().getRequestDispatcher("/mailingList.jsp").forward(request, response);
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
	
	public class MailingInfo {
		public String lastname;
		public String firstname;
		public String address;
		
		private MailingInfo(String lastname,String firstname,String address) {
			this.lastname = lastname;
			this.firstname=firstname;
			this.address=address;
		}
		
		public String getLast() {
			return lastname;
		}
		
		public String getFirst() {
			return firstname;
		}
		
		public String address() {
			return address;
		}

	}

}