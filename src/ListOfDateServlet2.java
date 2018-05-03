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
@WebServlet("/ListOfDateServlet2")
public class ListOfDateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOfDateServlet2() {
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
		String query = "SELECT * \r\n" + 
				"FROM Date D\r\n" + 
				"WHERE D.Profile1 =? or D.profile2 = ? ";
		PreparedStatement ps = null;
		try {
			ps = c.prepareStatement(query);
			ps.setString(1, profile);
			ps.setString(2, profile);
			ResultSet rs = ps.executeQuery();
			ArrayList<SaleReportInfo> listing = new ArrayList<SaleReportInfo>();
			while(rs.next()) {
				SaleReportInfo inf = new SaleReportInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
				listing.add(inf);
			}
			request.setAttribute("ListOfDate2", listing);
			getServletContext().getRequestDispatcher("/ListOfDate2.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


public class SaleReportInfo {

	public String ProfileID1;
	public String ProfileID2;
	public String CustRep;
	public String DateTime;
	public String Location;
	public String BookingFee;
	public String Comments;
	public String User1Rating;
	public String User2Rating;
	
	
	private SaleReportInfo(String c,String d,String a,String b,String e,String f,String g,String h,String i) {

		this.ProfileID1 = c;
		this.ProfileID2 = d;
		this.CustRep = a;
		this.DateTime = b;
		this.Location = e;
		this.BookingFee = f;
		this.Comments = g;
		this.User1Rating = h;
		this.User2Rating = i;
		
	}
	public String getProfileID1() {
		return ProfileID1;
	}public String getProfileID2() {
		return ProfileID2;
	}public String getCustRep() {
		return CustRep;
	}public String getDateTime() {
		return DateTime;
	}public String getLocation() {
		return Location;
	}public String getBookingFee() {
		return BookingFee;
	}public String getComments() {
		return Comments;
	}public String getUser1Rating() {
		return User1Rating;
	}public String getUser2Rating() {
		return User2Rating;
	}
}
}