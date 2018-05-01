

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
 * Servlet implementation class ListAllUserServlet
 */
@WebServlet("/BestCusRepServlet")
public class BestCusRepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BestCusRepServlet() {
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
    	String query = "SELECT P.FirstName,P.LastName\r\n" + 
    			"FROM Person P,\r\n" + 
    			"	(\r\n" + 
    			"	SELECT CustRep, MAX(Revenue)\r\n" + 
    			"	FROM\r\n" + 
    			"		(SELECT CustRep,SUM(BookingFee) AS Revenue\r\n" + 
    			"		FROM Date D\r\n" + 
    			"		GROUP BY CustRep) AS R\r\n" + 
    			"	) AS RT\r\n" + 
    			"WHERE RT.CustRep = P.SSN;";
    	try {
    		Statement s = c.createStatement();
    		ResultSet rs = s.executeQuery(query);
    		ArrayList<BestCusRepInfo>listing = new ArrayList<BestCusRepInfo>();
    		while(rs.next()) {
    			BestCusRepInfo inf = new BestCusRepInfo(rs.getString(1),rs.getString(2));
    			System.out.print(rs.getString(1));
    			listing.add(inf);
    		}
    		request.setAttribute("BestCusRep",listing);
    		getServletContext().getRequestDispatcher("/BestCusRep.jsp").forward(request, response);
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}




public class BestCusRepInfo {

	public String FirstName;
	public String LastName;
	
	
	private BestCusRepInfo(String c,String d) {

		this.FirstName = c;
		this.LastName = d;
	}
	public String getFirstName() {
		return FirstName;
	}public String getLastName() {
		return LastName;
	}
}
}
