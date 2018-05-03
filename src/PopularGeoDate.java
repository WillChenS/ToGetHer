

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
@WebServlet("/PopularGeoDate")
public class PopularGeoDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopularGeoDate() {
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
    	String query = "SELECT Geolocation, Count(Geolocation) as Count\r\n" + 
    			"FROM date\r\n" + 
    			"WHERE Geolocation is not null";
    	try {
    		Statement s = c.createStatement();
    		ResultSet rs = s.executeQuery(query);
    		ArrayList<GEODateInfo>listing = new ArrayList<GEODateInfo>();
    		while(rs.next()) {
    			GEODateInfo inf = new GEODateInfo(rs.getString(1),rs.getString(2));
    			System.out.print(rs.getString(1));
    			listing.add(inf);
    		}
    		request.setAttribute("PopularGeoDate",listing);
    		getServletContext().getRequestDispatcher("/PopularGeoDate.jsp").forward(request, response);
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}




public class GEODateInfo {

	public String GeoLocation;
	public String count;
	
	
	private GEODateInfo(String c,String a) {

		this.GeoLocation = c;
		this.count = a;
	}
	public String getGeoLocation() {
		return GeoLocation;
	}
	public String getcount() {
		return count;
	}
}
}
