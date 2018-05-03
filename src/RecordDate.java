

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
 * Servlet implementation class RecordDate
 */
@WebServlet("/RecordDate")
public class RecordDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordDate() {
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
		String employeeID = null;
		String profile1;
		String profile2;
		if(request.getSession().getAttribute("Role").equals("Customer")) {
			profile1 = request.getSession().getAttribute("ID").toString();
		}
		else {
			profile1 = request.getParameter("profile1");
			employeeID = request.getSession().getAttribute("ID").toString();
		}
		profile2 = request.getParameter("profile2");
		String datetime = request.getParameter("datetime");
		String location = request.getParameter("location");
		String bookingFee = request.getParameter("bookingfee");
		String comments = request.getParameter("comments");
		String user1rating = request.getParameter("user1rating");
		String user2rating = request.getParameter("user2rating");
		String query = "INSERT INTO date (Profile1, Profile2," + 
				"CustRep, Date_Time, Location, BookingFee," + 
				"Comments, User1Rating, User2Rating) VALUES ((SELECT ProfileID FROM Profile WHERE ProfileID = ?),"+
				"(SELECT ProfileID FROM Profile WHERE ProfileID = ?),?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = c.prepareStatement(query);
			ps.setString(1, profile1);
			ps.setString(2, profile2);
			ps.setString(3, employeeID);
			ps.setString(4, datetime);
			ps.setString(5, location);
			ps.setString(6, bookingFee);
			ps.setString(7, comments);
			ps.setString(8, user1rating);
			ps.setString(9, user2rating);
			ps.executeUpdate();
			request.setAttribute("return", "Successfully added date");
			request.getRequestDispatcher("/recordDate.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("return", "Failed to add date: One or more entries incorrect.");
			request.getRequestDispatcher("/recordDate.jsp").forward(request, response);
		}
	}

}
