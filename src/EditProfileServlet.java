

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String profile = request.getParameter("selectedProfile");
		String query = "SELECT * FROM Profile WHERE ProfileID = ?";
		
		Connection c = Database.getCon();
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(query);
			ps.setString(1, profile);
			ResultSet rs = ps.executeQuery();
			ArrayList<String>attributes = new ArrayList<String>();
			while (rs.next()) {
				for (int i = 1; i <= 12; i++) {
					attributes.add(rs.getString(i));
				}
			}
			request.setAttribute("attributes", attributes);
			
			ArrayList<String> colNames = new ArrayList<String>();
			ArrayList<String> selectables = new ArrayList<String>();
			ResultSetMetaData r = rs.getMetaData();
			for (int i = 1; i <= r.getColumnCount(); i++) {
				colNames.add(r.getColumnName(i));
				if (i != 11) selectables.add(r.getColumnName(i));
			}
			request.setAttribute("colNames",colNames);
			request.setAttribute("Selectables", selectables);
			
			request.getRequestDispatcher("alterCustInfo2.jsp").forward(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
