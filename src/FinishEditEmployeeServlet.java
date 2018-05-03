

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FinishEditEmployeeServlet
 */
@WebServlet("/FinishEditEmployeeServlet")
public class FinishEditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinishEditEmployeeServlet() {
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
		String profileID = request.getParameter("profileID");
		String selectedCol = request.getParameter("selectedCol");
		String newValue = request.getParameter("newValue");
		String toDelete = request.getParameter("delete");
		Connection c = Database.getCon();
		String query;
		if (toDelete != null && toDelete.equals("DELETE")) {
			newValue = null;
		}
		query = "UPDATE employee SET " + selectedCol + " = ? WHERE SSN = \"" + profileID + "\"";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(query);
			ps.setString(1, newValue);
			ps.executeUpdate();
			request.setAttribute("returnStatement", "Successfully updated.");
			request.getRequestDispatcher("/EmployeeInfoUpdated.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("returnStatement", "The value could not be updated.");
			request.getRequestDispatcher("/EmployeeInfoUpdated.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

}
