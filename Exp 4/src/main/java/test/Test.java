package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String rollno=request.getParameter("rollno");
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String year=request.getParameter("year");
		String dept=request.getParameter("dept");
		String sec=request.getParameter("sec");
		String phno=request.getParameter("phno");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String country=request.getParameter("country");
		String city=request.getParameter("city");
		String pincode=request.getParameter("pincode");
		pw.println("<html>");
		pw.println("<head></head>");
		pw.println("<body>");
		pw.println("<table border='1' ");
		pw.println("<tr>");
		pw.println("<td>Rollno</td><td>"+rollno+"</td></tr>");
		pw.println("<tr><td>Name</td><td>"+name+"</td></tr>");
		pw.println("<tr><td>Gender</td><td>"+gender+"</td></tr>");
		pw.println("<tr><td>Year</td><td>"+year+"</td></tr>");
		pw.println("<tr><td>Department</td><td>"+dept+"</td></tr>");
		pw.println("<tr><td>Section</td><td>"+sec+"</td></tr>");
		pw.println("<tr><td>Phone no.</td><td>"+phno+"</td></tr>");
		pw.println("<tr><td>Email</td><td>"+email+"</td></tr>");
		pw.println("<tr><td>Address</td><td>"+address+"</td></tr>");
		pw.println("<tr><td>Country</td><td>"+country+"</td></tr>");
		pw.println("<tr><td>City</td><td>"+city+"</td></tr>");
		pw.println("<tr><td>Pincode</td><td>"+pincode+"</td></tr>");
		pw.println("</table>");
		pw.println("</body>");
		pw.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
