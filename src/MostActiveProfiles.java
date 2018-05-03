

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
 * Servlet implementation class MostActiveCusServlet
 */
@WebServlet("/MostActiveProfiles")
public class MostActiveProfiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostActiveProfiles() {
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
    	String query = "SELECT Liker AS User, SUM(Count) AS Actions\r\n" + 
    			"FROM(\r\n" + 
    			"	SELECT L.Liker,COUNT(L.Liker) AS Count\r\n" + 
    			"	FROM likes L\r\n" + 
    			"	GROUP BY Liker\r\n" + 
    			"	UNION\r\n" + 
    			"	SELECT D.Profile1,COUNT(D.Profile1)\r\n" + 
    			"	FROM date D\r\n" + 
    			"	GROUP BY Profile1\r\n" + 
    			"	UNION\r\n" + 
    			"	SELECT R.ProfileA,COUNT(R.ProfileA)\r\n" + 
    			"	FROM blinddate R\r\n" + 
    			"	GROUP BY ProfileA\r\n" + 
    			"    ) AS L\r\n" + 
    			"GROUP BY Liker\r\n" + 
    			"ORDER BY Actions DESC LIMIT 6\r\n" ;
    	try {
    		Statement s = c.createStatement();
    		ResultSet rs = s.executeQuery(query);
    		ArrayList<MostActiveCusInfo>listing = new ArrayList<MostActiveCusInfo>();
    		while(rs.next()) {
    			MostActiveCusInfo inf = new MostActiveCusInfo(rs.getString(1),rs.getString(2));
    			listing.add(inf);
    		}
    		request.setAttribute("MostActiveProfiles",listing);
    		getServletContext().getRequestDispatcher("/MostActiveProfiles.jsp").forward(request, response);
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}




public class MostActiveCusInfo {

	public String ProfileID;
	public String count;
	
	
	private MostActiveCusInfo(String c,String d) {

		this.ProfileID = c;
		this.count = d;
	}
	public String getProfileID() {
		return ProfileID;
	}public String getcount() {
		return count;
	}
}
}
