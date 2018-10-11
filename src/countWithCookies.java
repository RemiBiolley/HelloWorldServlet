

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class countWithCookies
 */
@WebServlet("/countWithCookies")
public class countWithCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public countWithCookies() {
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
		if(cookies==null) {
			Cookie newCookie = new Cookie("VisitCounter", "1");
			response.addCookie(newCookie);
			out.println("C'est ta visite numéro " + newCookie.getValue());
		}
		else {
			int count = 0;
			for(int i=0; i< cookies.length; i++) {		
				if(Objects.equals(cookies[i].getName(), "VisitCounter")) {
					
					count = 1;
					int oldValue = Integer.parseInt(cookies[i].getValue());
					int newValue = oldValue + 1;
					out.println("C'est ta visite numéro " + "" + newValue);
					cookies[i].setValue("" + newValue);
					response.addCookie(cookies[i]);
				}
			}
			if(count==0) {
				Cookie newCookie = new Cookie("VisitCounter", "1");
				response.addCookie(newCookie);
				out.println("C'est ta visite numéro " + newCookie.getValue());
			}
		}
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
