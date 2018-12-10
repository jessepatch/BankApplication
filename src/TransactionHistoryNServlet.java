

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Customer;

/**
 * Servlet implementation class TransactionHistoryNServlet
 */
@WebServlet("/TransactionHistoryNServlet")
public class TransactionHistoryNServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionHistoryNServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(true);
		
		Customer customer = new Customer();
		customer = (Customer) session.getAttribute("customer");

		int numberTransactions = Integer.parseInt(request.getParameter("numberTransactions"));
		
		session.setAttribute("recentTransactions", customer.getCheckingAccount().viewHistory(numberTransactions));
		
		RequestDispatcher rs = request.getRequestDispatcher("transactionHistoryN.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
