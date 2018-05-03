

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DatedServlet
 */
@WebServlet("/DatedServlet")
public class DatedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatedServlet() {
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
		Connection c = Database.getCon();
		String profile = request.getParameter("profile");
		String query = "SELECT D.profile2 as ProfileID1 FROM Date D\r\n" + 
				"where D.profile1 =? \r\n" + 
				"Union (\r\n" + 
				"\r\n" + 
				"SELECT D.profile1 as ProfileID1 FROM Date D\r\n" + 
				"where D.profile2 =? \r\n" + 
				"\r\n" + 
				")\r\n" ;
		PreparedStatement ps = null;
		try {
			ps = c.prepareStatement(query);
			ps.setString(1, profile);
			ps.setString(2, profile);
			ResultSet rs = ps.executeQuery();
			ArrayList<DatedInfo> listing = new ArrayList<DatedInfo>();
			while(rs.next()) {
				DatedInfo inf = new DatedInfo(rs.getString(1));
						listing.add(inf);
			}
			request.setAttribute("Dated", listing);
			getServletContext().getRequestDispatcher("/Dated.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


public class DatedInfo {

	public String ProfileID1;
	
	
	private DatedInfo(String c) {

		this.ProfileID1 = c;
	}
	public String getProfileID1() {
		return ProfileID1;
	}
}
}