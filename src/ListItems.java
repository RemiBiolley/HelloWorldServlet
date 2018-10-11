

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
		String newItem = request.getParameter("newItem");
		
		if(s.isNew()) {
			ArrayList<String> passedItems = new ArrayList<String>();
			passedItems.add(newItem);
			s.setAttribute("passedItems", passedItems);
		}
		else {
			ArrayList<String> passedItems = (ArrayList<String>)s.getAttribute("passedItems");
			passedItems.add(newItem);
			s.setAttribute("passedItems", passedItems);
		}
		
		ArrayList<String>passedItems = (ArrayList<String>)s.getAttribute("passedItems");
		
		for(int i=0 ; i<passedItems.size() ; i++) {
			out.println(passedItems.get(i));
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
