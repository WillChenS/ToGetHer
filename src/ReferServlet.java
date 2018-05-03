

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReferServlet
 */
@WebServlet("/ReferServlet")
public class ReferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReferServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String currProf = request.getSession().getAttribute("ID").toString();
		String profile1 = request.getParameter("profile1");
		String profile2 = request.getParameter("profile2");
		String dateTime = request.getParameter("dateTime");
		
		Connection c = Database.getCon();
		String sql = "INSERT INTO blinddate "
				+ "VALUES(?,?,?,?) ";
		
		if(profile1.equals(currProf) || profile2.equals(currProf) || profile1.equals(profile2)) {
			request.getSession().setAttribute("referMsg", "Can't set yourself or the same person on"
					+ " a blind date");
			response.sendRedirect("Refer.jsp");
		}else {
		
			try {
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setString(1, currProf);
				ps.setString(2, profile1);
				ps.setString(3, profile2);
				ps.setString(4, dateTime);
			
				int rowcount = ps.executeUpdate();
				request.getSession().setAttribute("referMsg", profile1 + " and " + profile2 + " are set "
					+ "on a blind date!!");
				response.sendRedirect("Refer.jsp");
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
				request.getSession().setAttribute("referMsg", "Some profileID were wrong");
				response.sendRedirect("Refer.jsp");
			}
		
			System.out.println("Profile1: " +profile1);
			System.out.println(profile2);
			System.out.println(dateTime);
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
