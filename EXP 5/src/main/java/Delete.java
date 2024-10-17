

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String delete=request.getParameter("deleteBook");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String URL = "jdbc:mysql://localhost:3306/vinoth";
			Connection conn = DriverManager.getConnection(URL, "root", "");
			
			String query="delete from library_new where book_name=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, delete);
			
			// Execute the update query
			int rs= ps.executeUpdate();
			
			if (rs> 0) {
				pw.println("Book Deleted Successfully");
			} else {
				pw.println("Book Not Found");
			}
			
			// Close resources
			ps.close();
			conn.close();
		} catch (Exception e) {
			pw.print("Error: " + e.getMessage());		}
	}

}
