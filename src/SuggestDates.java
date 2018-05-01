

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
 * Servlet implementation class SuggestDates
 */
@WebServlet("/SuggestDates")
public class SuggestDates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuggestDates() {
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
		Database db = new Database();
		Connection c = db.getCon();
		String profile = request.getParameter("profile");
		String query = "SELECT profile1,User1Rating,user2rating " + 
				"FROM date,profile " + 
				"WHERE profileID=? and profileID!=profile1 and profileID!=profile2 and user1rating >=4 and user2rating >=4";
		PreparedStatement ps = null;
		try {
			ps = c.prepareStatement(query);
			ps.setString(1, profile);
			ResultSet rs = ps.executeQuery();
			ArrayList<String> suggestedProfiles = new ArrayList<String>();
			while(rs.next()) {
				suggestedProfiles.add(rs.getString(1));
			}
			request.setAttribute("list", suggestedProfiles);
			getServletContext().getRequestDispatcher("/dateSuggestions.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
