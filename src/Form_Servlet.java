

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Form_Servlet
 */
@WebServlet("/Form_Servlet")
public class Form_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Form_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] names = new String[]  {"Prenom", "Nom_de_famille", "Date_de_naissance", "Sexe"};
		String[] ids = new String[]  {"firstname", "lastname", "birthdate", "sex"};
		ArrayList <Cookie> newCookies= new ArrayList <Cookie>();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		for(int i = 0 ; i<names.length ; i++) {
			newCookies.add(new Cookie(names[i], request.getParameter(ids[i])));
			newCookies.get(i).setMaxAge(60*60*24);
		}
		
		for(int i = 0 ; i<newCookies.size() ; i++) {
			response.addCookie(newCookies.get(i));
		}
		
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Lab1</TITLE></HEAD>");
		out.println("<BODY>");
		
		out.println("<table>");
		out.println("<tr>");
		for (int i = 0; i < names.length; i++) {
			out.println("<th>" + names[i] + "</th>");
		}
		out.println("</tr>");
		out.println("<tr>");
		for (int i = 0; i < ids.length; i++) {
			if(request.getParameter(ids[i]) == null || Objects.equals(request.getParameter(ids[i]), "")) {
				out.println("<td>Non spécifié</td>");
			}
			else {
				out.println("<td>" + request.getParameter(ids[i]) + "</td>");
			}
		}
		out.println("</tr>");
		out.println("</table>");
		
		out.println("</BODY></HTML>");
		out.close();
		doGet(request, response);
	}

}
