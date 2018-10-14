

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ListItems
 */
@WebServlet("/ListItems")
public class ListItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListItems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession s = request.getSession(true);
		String[] newItem = {request.getParameter("newItem"), "0"};
		int occurences = 0;
		ArrayList <String[]> passedItems = new ArrayList<String[]>();
		
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Lab1</TITLE></HEAD>");
		out.println("<BODY>");
		
		if(s.isNew()) {
			passedItems.add(newItem);
			s.setAttribute("passedItems", passedItems);
		}
		else {
			passedItems = (ArrayList<String[]>)s.getAttribute("passedItems");
			for(int i=0 ; i<passedItems.size() ; i++) {
				if(Objects.equals(newItem[0], passedItems.get(i)[0])){
					occurences =Integer.parseInt(passedItems.get(i)[1]) + 1;
					passedItems.get(i)[1] = "" + occurences;
					break;
				}
			}
			if(occurences==0) {
				passedItems.add(newItem);
			}
			s.setAttribute("passedItems", passedItems);
		}
		
		for(int i=0 ; i<passedItems.size() ; i++) {
			out.println(passedItems.get(i)[0] + " ( x" + passedItems.get(i)[1] + " ) <br>");
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
