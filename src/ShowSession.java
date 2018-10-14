

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class ShowSession
 */
@WebServlet("/ShowSession")
public class ShowSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession s = request.getSession(true);
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Lab1</TITLE></HEAD>");
		out.println("<BODY>");
		
		if(s.isNew()) {
			out.println("<h1>Welcome on my site</h1>");
			out.println("C'est ta première visite chez nous ! Bienvenue ! Prends le temps de remplir ce questionnaire : <br><br>");
			s.setAttribute("nbVisites", 1);
			out.println("<form method=\"post\" action=\"/HelloWorldServlet/Form_Servlet\">");
			out.println("First name: <input type=\"text\" name=\"firstname\"> <br>");
			out.println("Last name: <input type=\"text\" name=\"lastname\"> <br>");
			out.println("Birth date: <input type=\"date\" name=\"birthdate\"> <br>");
			out.println("<input type=\"submit\" value=\"envoyer\">");
		}
		else {
			out.println("Welcome back ! ");
			s.setAttribute("nbVisites", (Integer)s.getAttribute("nbVisites")+1);
			Cookie[] cookies = request.getCookies();
			String firstname = "", lastname= "", birthdate="";
			long daysToBirth = 0;
			
			SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			for(int i = 0 ; i< cookies.length ; i++) {
				
				if(Objects.equals(cookies[i].getName(), "Prenom")) {
					
					firstname = cookies[i].getValue();
				}
				else if(Objects.equals(cookies[i].getName(), "Nom_de_famille")) {
					lastname = cookies[i].getValue();
				}
				else if(Objects.equals(cookies[i].getName(), "Date_de_naissance") && cookies[i].getName().length() >= 10) {
					birthdate= cookies[i].getValue();
				}
				
			}
			try {
				Date birth = myFormat.parse(birthdate);
				Date today = myFormat.parse(myFormat.format(new Date()));
				long diff = today.getTime() - birth.getTime();
				System.out.println(diff);
				daysToBirth=TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
				if(daysToBirth>365) {
					daysToBirth= daysToBirth%365;
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			out.println("<br> Hi, " + firstname + " " + lastname + ". There are " + daysToBirth + " days to your birthday. <br>");
			
			out.println("C'est ta visite numéro " + s.getAttribute("nbVisites"));
		}
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
