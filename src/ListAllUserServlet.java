

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
@WebServlet("/ListAllUserServlet")
public class ListAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAllUserServlet() {
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
	String query = "SELECT U.SSN,U.PPP,U.Rating,U.DateOfLastAct,P.Password,P.FirstName,P.LastName,P.Street,P.City,P.State,P.Zipcode,P.Email,P.Telephone FROM User U,Person P\r\n" + 
			"WHERE U.SSN = P.SSN";
	try {
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(query);
		ArrayList<UserInfo>listing = new ArrayList<UserInfo>();
		while(rs.next()) {
			UserInfo inf = new UserInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13));
			
			listing.add(inf);
		}
		request.setAttribute("ListAllUserList",listing);
		getServletContext().getRequestDispatcher("/ListAllUser.jsp").forward(request, response);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
}

public class UserInfo {
	public String SSN;
	public String PPP;
	public String Rating;
	public String DateOfLastAct;
	public String Password;
	public String FirstName;
	public String LastName;
	public String Street;
	public String City;
	public String State;
	public String ZipCode;
	public String Email;
	public String Telephone;
	
	
	private UserInfo(String a,String k,String l,String m,String b,String c,String d,String e,String f,String g,String h,String i,String j) {
		this.SSN = a;
		this.PPP =k;
		this.Rating = l;
		this.DateOfLastAct = m;
		this.Password = b;
		this.FirstName = c;
		this.LastName = d;
		this.Street = e;
		this.City = f;
		this.State = g;
		this.ZipCode = h;
		this.Email = i;
		this.Telephone = j;
	}
	
	public String getSSN() {
		return SSN;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public String getPPP() {
		return PPP;
	}public String getRating() {
		return Rating;
	}public String getDateOfLastAct() {
		return DateOfLastAct;
	}public String getFirstName() {
		return FirstName;
	}public String getLastName() {
		return LastName;
	}public String getStreet() {
		return Street;
	}public String getCity() {
		return City;
	}public String getState() {
		return State;
	}public String getZipCode() {
		return ZipCode;
	}public String getEmail() {
		return Email;
	}public String getTelephone() {
		return Telephone;

}
}
}