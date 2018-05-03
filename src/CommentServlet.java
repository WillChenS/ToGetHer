

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
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection c = Database.getCon();
		String currentPro = request.getSession().getAttribute("ID").toString();
		String p1 = request.getParameter("profile1");
		String p2 = request.getParameter("profile2");
		String dateTime = request.getParameter("date") + " " + request.getParameter("time");
		String prevCmnts = request.getParameter("prevCmnts");
		String newCmnt = request.getParameter("newCmnt");
		System.out.println("prev: " + prevCmnts);
		System.out.println("new: " + newCmnt);
		String sql = "UPDATE date SET Comments = ? "
				+ "WHERE Profile1 = ? AND Profile2 = ? AND Date_Time = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			if(prevCmnts.equals("Comments Here")) {
				prevCmnts = "";
			}
			prevCmnts = prevCmnts + currentPro + ": " + newCmnt + " <br> ";
			
			ps.setString(1, prevCmnts);
			ps.setString(2, p1);
			ps.setString(3, p2);
			ps.setString(4, dateTime);
			
			int rowcount = ps.executeUpdate();
			response.sendRedirect("UserHome.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.getSession().setAttribute("errorMsg", "Invalid input");
			response.sendRedirect("UserHome.jsp");
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
