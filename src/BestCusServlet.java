

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
@WebServlet("/BestCusServlet")
public class BestCusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BestCusServlet() {
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
    			"From Person P, Profile Pr, (\r\n" + 
    			"	SELECT RT.Profile1, MAX(TRevenue)\r\n" + 
    			"	FROM(\r\n" + 
    			"		SELECT R.Profile1, SUM(Revenue) as TRevenue\r\n" + 
    			"			FROM\r\n" + 
    			"			((SELECT Profile1,SUM(BookingFee) as Revenue\r\n" + 
    			"					FROM Date D\r\n" + 
    			"					GROUP BY CustRep)\r\n" + 
    			"			UNION\r\n" + 
    			"			(SELECT Profile2,SUM(BookingFee) as Revenue\r\n" + 
    			"					FROM Date D\r\n" + 
    			"					GROUP BY CustRep)) as R\r\n" + 
    			"			GROUP BY Profile1) as RT\r\n" + 
    			"		) as LT\r\n" + 
    			"	WHERE LT.Profile1 = Pr.ProfileID AND Pr.OwnerSSN = P.SSN\r\n";
    	try {
    		Statement s = c.createStatement();
    		ResultSet rs = s.executeQuery(query);
    		ArrayList<BestCusInfo>listing = new ArrayList<BestCusInfo>();
    		while(rs.next()) {
    			BestCusInfo inf = new BestCusInfo(rs.getString(1),rs.getString(2));
    			System.out.print(rs.getString(1));
    			listing.add(inf);
    		}
    		request.setAttribute("BestCus",listing);
    		getServletContext().getRequestDispatcher("/BestCus.jsp").forward(request, response);
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}




public class BestCusInfo {

	public String FirstName;
	public String LastName;
	
	
	private BestCusInfo(String c,String d) {

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
