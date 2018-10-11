

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadCookie
 */
@WebServlet("/ReadCookie")
public class ReadCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();

		out.println("<HTML>");
		out.println("<HEAD><TITLE>Lab1</TITLE></HEAD>");
		out.println("<BODY>");
		
		out.println("<table>");
		out.println("<tr>");
		for (int i = 0; i < cookies.length; i++) {
			if(!Objects.equals(cookies[i].getName(), "JSESSIONID")) {
				out.println("<th>" + cookies[i].getName() + "</th>");
			}
		}
		out.println("</tr>");
		out.println("<tr>");
		for (int i = 0; i < cookies.length; i++) {
			if(!Objects.equals(cookies[i].getName(), "JSESSIONID")) {
				out.println("<td>" + cookies[i].getValue() + "</td>");
			}
		}
		out.println("</tr>");
		out.println("</table>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
