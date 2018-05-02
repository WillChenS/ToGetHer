

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LikeServlet
 */
@WebServlet("/LikeServlet")
public class LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String profID = request.getSession().getAttribute("ID").toString();
		String likee = request.getParameter("likee");
		java.util.Date date = new java.util.Date();
		java.sql.Timestamp sqlDT = new java.sql.Timestamp(date.getTime());
		
		Connection c = Database.getCon();
		String sql = "INSERT INTO likes VALUES (?, "
				+ "(SELECT ProfileID from Profile where ProfileID=?)"
				+ ", ?)";
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, profID);
			ps.setString(2, likee);
			ps.setTimestamp(3, sqlDT);
			
			int rowcount = ps.executeUpdate();
			request.getSession().setAttribute("Msg", likee + " Liked");
			response.sendRedirect("Like.jsp");
			System.out.println("liked");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.getSession().setAttribute("Msg", "The profile ID was wrong or already liked");
			response.sendRedirect("Like.jsp");
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
