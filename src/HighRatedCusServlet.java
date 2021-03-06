

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
@WebServlet("/HighRatedCusServlet")
public class HighRatedCusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HighRatedCusServlet() {
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
    	String query = "SELECT P.FirstName,P.LastName,ratings.rating\r\n" + 
    			"FROM Person P, (\r\n" + 
    			"	SELECT SSN, Rating\r\n" + 
    			"	FROM User U\r\n" + 
    			"    ) AS ratings\r\n" + 
    			"WHERE ratings.SSN = P.SSN\r\n" + 
    			"ORDER BY rating DESC LIMIT 5\r\n" ;
    	try {
    		Statement s = c.createStatement();
    		ResultSet rs = s.executeQuery(query);
    		ArrayList<HighRatedCusInfo>listing = new ArrayList<HighRatedCusInfo>();
    		while(rs.next()) {
    			HighRatedCusInfo inf = new HighRatedCusInfo(rs.getString(1),rs.getString(2),rs.getString(3));
    			System.out.print(rs.getString(1));
    			listing.add(inf);
    		}
    		request.setAttribute("HighRatedCus",listing);
    		getServletContext().getRequestDispatcher("/HighRatedCus.jsp").forward(request, response);
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
	public String LastName;
	public String rating;
	
	
	private HighRatedCusInfo(String c,String d,String a) {

		this.FirstName = c;
		this.LastName = d;
		this.rating = a;
	}
	public String getFirstName() {
		return FirstName;
	}public String getLastName() {
		return LastName;
	}public String getrating() {
		return rating;
	}
}
}
