

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class OrderChecksServlet
 */
@WebServlet("/OrderChecksServlet")
public class OrderChecksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderChecksServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		boolean orderedChecksRecently = false;
		
		HttpSession session = request.getSession(true);
		try {
		orderedChecksRecently = (boolean) session.getAttribute("orderedChecksRecently");
		}
		catch (NullPointerException ex) {
			 orderedChecksRecently = false;
		}
		if(!orderedChecksRecently) {
			orderedChecksRecently = true;
		} else {
			RequestDispatcher rs = request.getRequestDispatcher("account.jsp");
			rs.forward(request, response);
		}
		
		session.setAttribute("orderedChecksRecently", orderedChecksRecently);
		
		RequestDispatcher rs = request.getRequestDispatcher("account.jsp");
		rs.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
