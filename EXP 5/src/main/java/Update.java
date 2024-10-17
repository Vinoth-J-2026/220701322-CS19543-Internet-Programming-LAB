

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
 * Servlet implementation class Update
 */
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
		String book=request.getParameter("bookName");
		String updatef=request.getParameter("updateCol");
		String updatev=request.getParameter("updateVal");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String URL = "jdbc:mysql://localhost:3306/vinoth";
			Connection conn = DriverManager.getConnection(URL, "root", "");
			
			String query = "UPDATE library_new SET " + updatef + " = ? WHERE book_name = ?";
	        PreparedStatement ps = conn.prepareStatement(query);	        
	        ps.setString(1, updatev);
	        ps.setString(2, book);
			int rs=ps.executeUpdate();
			if(rs>0) {
				pw.println("Book Updated Successfully.");
			}
			else {
				pw.println("Book Not Found.");
			}
			ps.close();
			conn.close();
			}catch(Exception e) {
			pw.println(e);
		}
	}

}
