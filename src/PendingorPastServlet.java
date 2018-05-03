

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PendingorPastServlet
 */
@WebServlet("/PendingorPastServlet")
public class PendingorPastServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PendingorPastServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			java.util.Date dt = new java.util.Date();
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(dt);
			String profile = request.getParameter("profile");
			
			Connection c = Database.getCon();
			String sql;
			PreparedStatement ps;
			String choose = request.getParameter("choose");
			System.out.println(choose);
			if(choose.equals("pending")) { 
				sql = "SELECT D.Profile1, D.Profile2, D.Date_Time "
						+ "FROM date D "
						+ "WHERE ((D.Profile1 = ?) OR (D.Profile2 = ?)) AND "
						+ "(D.Date_Time > ?)";
				ps = c.prepareStatement(sql);
			}else {
				sql = "SELECT D.Profile1, D.Profile2, D.Date_Time "
						+ "FROM date D "
						+ "WHERE ((D.Profile1 = ?) OR (D.Profile2 = ?)) AND "
						+ "(D.Date_Time < ?)";
				ps = c.prepareStatement(sql);
			}
			ps.setString(1, profile);
			ps.setString(2, profile);
			ps.setString(3, currentTime);
			
			ResultSet rs = ps.executeQuery();

			
			int s = 0;
			while(rs.next()) {
				s++;
				request.setAttribute("profile1"+s, rs.getString(1));
				request.setAttribute("profile2"+s, rs.getString(2));
				request.setAttribute("dateTime"+s, rs.getTimestamp(3).toString());
			}
			request.setAttribute("length", s);
			request.setAttribute("choose", choose);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/PorPResult.jsp");
			dispatcher.forward(request, response);
			
				
		}catch(Exception e) {
			
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
