

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
 * Servlet implementation class EmployeeInfo
 */
@WebServlet("/EmployeeInfo")
public class EmployeeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Database db = new Database();
		Connection c = db.getCon();
		String query = "SELECT DISTINCT P.FirstName,P.LastName,P.Email,P.Telephone,E.Role FROM Person P, Employee E WHERE E.SSN = P.SSN ORDER BY LastName";
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(query);
			ArrayList<EmployeeInf>listing = new ArrayList<EmployeeInf>();
			while(rs.next()) {
				EmployeeInf inf = new EmployeeInf(rs.getString(2),rs.getString(1),rs.getString(3),rs.getString(4),rs.getString(5));
				listing.add(inf);
			}
			request.setAttribute("EmployeeList",listing);
			getServletContext().getRequestDispatcher("/EmployeeInfo.jsp").forward(request, response);
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

	public class EmployeeInf{
		
		public String lastname;
		public String firstname;
		public String address;
		public String telephone;
		public String role;
		
		private EmployeeInf(String lastname,String firstname,String address,String telephone, String role) {
			this.lastname = lastname;
			this.firstname=firstname;
			this.address=address;
			this.telephone=telephone;
			this.role=role;
		}
		
		public String getLast() {
			return lastname;
		}
		
		public String getFirst() {
			return firstname;
		}
		
		public String address() {
			return address;
		}
		
		public String telephone() {
			return telephone;
		}
		
		public String role() {
			return role;
		}

	}
}
