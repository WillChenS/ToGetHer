

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SrchProServlet
 */
@WebServlet("/SrchProServlet")
public class SrchProServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrchProServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			Connection c = Database.getCon();
			
		
			String height = request.getParameter("height");
			String weight = request.getParameter("weight");
			String hairColor = request.getParameter("hairColor");
			String hobbies = request.getParameter("hobbies");
			String[] hobArr = new String[3];
			String[] toCopy = hobbies.split(",");
			for(int i=0;i<toCopy.length;i++) {
				hobArr[i] = toCopy[i].trim();
			}
			String currPro = request.getSession().getAttribute("ID").toString();
			
			try {
				String sql = "SELECT ProfileID, Height, Weight, HairColor, Age "
							+"FROM (SELECT * FROM profile NATURAL JOIN Hobbies WHERE M_F NOT IN "
							+ "(SELECT M_F FROM profile WHERE ProfileID = ?)) as S "
							+ "WHERE (height = ? OR weight = ? OR hairColor = ? OR Hobbies = ? "
							+ "OR Hobbies=? OR Hobbies=?) AND "
							+ "((SELECT DatingAgeRangeStart FROM profile WHERE ProfileID = ?) < Age AND "
							+ "(SELECT DatingAgeRangeEnd From profile WHERE ProfileID = ?) > Age) "
							+ "Group By ProfileID";
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setString(1, currPro);
				ps.setInt(2, Integer.parseInt(height));
				ps.setInt(3, Integer.parseInt(weight));
				ps.setString(4, hairColor);
				ps.setString(5, hobArr[0]);
				ps.setString(6, hobArr[1]);
				ps.setString(7, hobArr[2]);
				ps.setString(8, currPro);
				ps.setString(9, currPro);
				
				ResultSet rs = ps.executeQuery();
				
				int s = 0;
				while(rs.next()) {
					s++;
					request.setAttribute("ProfileID"+s, rs.getString(1));
					request.setAttribute("Height"+s, rs.getInt(2));
					request.setAttribute("Weight"+s, rs.getInt(3));
					request.setAttribute("HairColor"+s, rs.getString(4));	
					request.setAttribute("Age"+s, rs.getInt(5));
				
				}
				request.setAttribute("length", s);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/SearchResults.jsp");
				dispatcher.forward(request, response);
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				response.sendRedirect("SearchProfile.jsp");
			}
			
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
