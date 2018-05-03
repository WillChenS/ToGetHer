

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteDateServlet
 */
@WebServlet("/DeleteDateServlet")
public class DeleteDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String p1 = request.getParameter("profile1");
		String p2 = request.getParameter("profile2");
		String dateTime = request.getParameter("date") + " " + request.getParameter("time");
		
		
		
		Connection c = Database.getCon();
		String sql = "DELETE FROM date "
				+ "WHERE Profile1=? AND Profile2=? AND Date_Time = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, p1);
			ps.setString(2, p2);
			ps.setString(3, dateTime);
			
			ps.executeUpdate();
			response.sendRedirect("UserHome.jsp");
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
