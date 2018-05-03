

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
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
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
		doGet(request, response);
		String ssn = request.getParameter("selectedUser");
		Connection c = Database.getCon();
		String query;
		query = "DELETE FROM Person WHERE ssn=?";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(query);
			ps.setString(1, ssn);
			ps.executeUpdate();
			request.setAttribute("returnStatement", "Successfully updated.");
			request.getRequestDispatcher("/UserDeleted.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("returnStatement", "The value could not be updated.");
			request.getRequestDispatcher("/UserDeleted.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

}
