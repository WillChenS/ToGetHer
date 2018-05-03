

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
@WebServlet("/PersonalizedSuggestion")
public class PersonalizedSuggestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalizedSuggestion() {
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
    	String query = "\r\n" + 
    			"SELECT ProfileB AS ProfileID\r\n" + 
    			"FROM blinddate\r\n" + 
    			"WHERE ProfileC = 'Fletcher2013'\r\n" + 
    			"UNION\r\n" + 
    			"SELECT ProfileC\r\n" + 
    			"FROM blinddate\r\n" + 
    			"WHERE ProfileB = 'Fletcher2013'\r\n" + 
    			"UNION\r\n" + 
    			"SELECT Profile1\r\n" + 
    			"FROM SuggestedBy\r\n" + 
    			"WHERE Profile2 = 'Fletcher2013'\r\n" + 
    			"UNION \r\n" + 
    			"SELECT Profile2\r\n" + 
    			"FROM SuggestedBy\r\n" + 
    			"WHERE Profile1 = 'Fletcher2013';\r\n";
    	try {
    		Statement s = c.createStatement();
    		ResultSet rs = s.executeQuery(query);
    		ArrayList<GEODateInfo>listing = new ArrayList<GEODateInfo>();
    		while(rs.next()) {
    			GEODateInfo inf = new GEODateInfo(rs.getString(1));
    			System.out.print(rs.getString(1));
    			listing.add(inf);
    		}
    		request.setAttribute("PersonalizedSuggestion",listing);
    		getServletContext().getRequestDispatcher("/PersonalizedSuggestion.jsp").forward(request, response);
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

	public String profile;
	
	
	private GEODateInfo(String c) {

		this.profile = c;
		
	}
	public String getprofile() {
		return profile;
	}
	
}
}
