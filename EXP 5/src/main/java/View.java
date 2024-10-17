

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
 * Servlet implementation class View
 */
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View() {
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
		String view=request.getParameter("viewBook");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String URL = "jdbc:mysql://localhost:3306/vinoth";
			Connection conn = DriverManager.getConnection(URL, "root", "");
			
			String query="select * from library_new where book_name=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,view);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				pw.println("<br>The Requested Book ");
				pw.println("<br>Book Name :"+rs.getString(1)+"<br>");
				pw.println("Book Author :"+rs.getString(2)+"<br>");
				pw.println("Book Publisher :"+rs.getString(3)+"<br>");
				pw.println("Book edition :"+rs.getInt(4)+"<br>");
				pw.println("Book Price :"+rs.getFloat(5)+"<br>");
				pw.println("Book Category :"+rs.getString(6)+"<br>");
			}
			else {
				pw.println("Book Not Found");
			}

		}catch(Exception e) {
			pw.print(e);
		}
	}

}
