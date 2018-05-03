

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
@WebServlet("/HighRatedProfiles")
public class HighRatedProfiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HighRatedProfiles() {
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
    	String query = "SELECT ProfileID,ratings.Rating\r\n" + 
    			"FROM Profile P, (\r\n" + 
    			"	SELECT SSN, Rating\r\n" + 
    			"	FROM User U\r\n" + 
    			"    ) AS ratings\r\n" + 
    			"WHERE ratings.SSN = P.OwnerSSN\r\n" + 
    			"ORDER BY rating DESC LIMIT 5\r\n" ;
    	try {
    		Statement s = c.createStatement();
    		ResultSet rs = s.executeQuery(query);
    		ArrayList<HighRatedCusInfo>listing = new ArrayList<HighRatedCusInfo>();
    		while(rs.next()) {
    			HighRatedCusInfo inf = new HighRatedCusInfo(rs.getString(1),rs.getString(2));
    			System.out.print(rs.getString(1));
    			listing.add(inf);
    		}
    		request.setAttribute("HighRatedProfiles",listing);
    		getServletContext().getRequestDispatcher("/HighRatedProfiles.jsp").forward(request, response);
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}




public class HighRatedCusInfo {

	public String FirstName;
	public String rating;
	
	
	private HighRatedCusInfo(String c,String a) {

		this.FirstName = c;
		this.rating = a;
	}
	public String getFirstName() {
		return FirstName;
	}public String getrating() {
		return rating;
	}
}
}
