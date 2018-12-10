

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Customer;

/**
 * Servlet implementation class TransactionHistoryMonthServlet
 */
@WebServlet("/TransactionHistoryMonthServlet")
public class TransactionHistoryMonthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionHistoryMonthServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		
		Customer customer = new Customer();
		customer = (Customer) session.getAttribute("customer");

		LocalDateTime now = LocalDateTime.now();
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM");
		 String yearMonth = dtf.format(now);
		
		session.setAttribute("recentTransactions", customer.getCheckingAccount().viewHistory(yearMonth));
		
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
