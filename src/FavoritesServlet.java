

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FavoritesServlet
 */
@WebServlet("/FavoritesServlet")
public class FavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoritesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection c = Database.getCon();
		String liker = request.getParameter("profile");
		String sql = "SELECT Likee FROM likes WHERE Liker = ?";
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, liker);
			
			ResultSet rs = ps.executeQuery();
			
			int s=0;
			while(rs.next()) {
				s++;
				request.setAttribute("likee"+s, rs.getString(1));
			}
			request.setAttribute("length", s);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FavResults.jsp");
			dispatcher.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.getSession().setAttribute("errorMsg", "You entered some wrong values. Please try again");
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
