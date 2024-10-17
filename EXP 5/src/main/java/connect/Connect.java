package connect;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Connect
 */
public class Connect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connect() {
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

		String bname = request.getParameter("book_name");
		String aname = request.getParameter("book_author");
		String pname = request.getParameter("book_publisher");
		String edition = request.getParameter("book_edition");
		String price = request.getParameter("book_price");
		String category = request.getParameter("book_category");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String URL = "jdbc:mysql://localhost:3306/vinoth";
			Connection conn = DriverManager.getConnection(URL, "root", "");

			// Insert SQL query with placeholders
			String query = "INSERT INTO library_new (book_name,author,publisher,edition,price,category) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);

			// Setting values for the placeholders
			ps.setString(1, bname);
			ps.setString(2, aname);
			ps.setString(3, pname);
			ps.setString(4, edition);
			ps.setString(5, price);
			ps.setString(6, category);
			int res = ps.executeUpdate();
			if (res != 0) {
				pw.println("<br>New Row Added successfully.");
				pw.println("<br>Book Name "+bname+"<br>");
				pw.println("Book Author "+aname+"<br>");
				pw.println("Book Publisher "+pname+"<br>");
				pw.println("Book edition "+edition+"<br>");
				pw.println("Book Price "+price+"<br>");
				pw.println("Book Category "+category+"<br>");
			} else {
				pw.println("Customer Details Insertion Failure...");
			}

			ps.close();
			conn.close();
		} catch (Exception e) {
			pw.println(e);
		}
	}

}
