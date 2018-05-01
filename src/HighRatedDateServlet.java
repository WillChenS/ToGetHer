

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class HighRatedCusServlet
 */
@WebServlet("/HighRatedDateServlet")
public class HighRatedDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HighRatedDateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	// TODO Auto-generated method stub
    	response.getWriter().append("Served at: ").append(request.getContextPath());
    	Connection c = Database.getCon();
    	String query = "SELECT DATE_FORMAT(DateOfLastAct, '%m-%d') as CalendarDate, AVG(Rating) as AverageRating\r\n" + 
    			"FROM User u\r\n" + 
    			"GROUP BY CalendarDate\r\n" + 
    			"ORDER BY Rating DESC LIMIT 4\r\n";
    	try {
    		Statement s = c.createStatement();
    		ResultSet rs = s.executeQuery(query);
    		ArrayList<HighRatedDateInfo>listing = new ArrayList<HighRatedDateInfo>();
    		while(rs.next()) {
    			HighRatedDateInfo inf = new HighRatedDateInfo(rs.getString(1),rs.getString(2));
    			System.out.print(rs.getString(1));
    			listing.add(inf);
    		}
    		request.setAttribute("HighRatedDate",listing);
    		getServletContext().getRequestDispatcher("/HighRatedDate.jsp").forward(request, response);
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}




public class HighRatedDateInfo {

	public String Date;
	public String rating;
	
	
	private HighRatedDateInfo(String c,String a) {

		this.Date = c;
		this.rating = a;
	}
	public String getDate() {
		return Date;
	
	}public String getrating() {
		return rating;
	}
}
}
