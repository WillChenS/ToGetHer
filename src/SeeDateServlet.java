

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
 * Servlet implementation class SeeDateServlet
 */
@WebServlet("/SeeDateServlet")
public class SeeDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeDateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Seedate opened");
		String profId = request.getSession().getAttribute("ID").toString();
		
		Connection c = Database.getCon();
		String sql = "SELECT * FROM date WHERE Profile1 = ? or Profile2 = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, profId);
			ps.setString(2, profId);
			ResultSet rs = ps.executeQuery();
			
			System.out.println("Query successful");
			int suffix = 0;
			while(rs.next()) {
			suffix++;
			request.setAttribute("profile1"+suffix, rs.getString(1));
			request.setAttribute("profile2"+suffix, rs.getString(2));
			request.setAttribute("dateTime"+suffix, rs.getTimestamp(4).toString());
			request.setAttribute("location"+suffix, rs.getString(5));
			request.setAttribute("booking"+suffix, rs.getInt(6));
			request.setAttribute("comments"+suffix, rs.getString(7));
			request.setAttribute("u1Rating"+suffix, rs.getInt(8));
			request.setAttribute("u2Rating"+suffix, rs.getInt(9));
			request.setAttribute("geoLoc"+suffix, rs.getString(10));
			System.out.println(rs.getString(1));
			}
			request.setAttribute("length", suffix);
			
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/SeeDates.jsp");
			dispatcher.forward(request,response);
			
			
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
