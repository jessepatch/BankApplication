

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Bank;
import com.user.Customer;
import com.user.InsufficientFundsException;

/**
 * Servlet implementation class FundsTransferServlet
 */
@WebServlet("/FundsTransferServlet")
public class FundsTransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FundsTransferServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(true);
		
		Bank bank = new Bank();
		bank = (Bank) session.getAttribute("bank");

		//the account that will be transferring money from their account
		Customer customer = new Customer();
		customer = (Customer) session.getAttribute("customer");
		
		String transferEmail = request.getParameter("transferEmail");
		int transferAmount = Integer.parseInt(request.getParameter("transferAmount"));
		
		//represents the account that will receive money
		Customer customer2 = new Customer();
		
		for(int u = 0; u < bank.customers.size(); u++) {
			if(transferEmail.equals(bank.customers.get(u).getEmail())) {
				customer2 = bank.customers.get(u);
			}
		}
		
		try {
			customer.getCheckingAccount().makeWithdrawal(transferAmount);
			customer2.getCheckingAccount().makeDeposit(transferAmount);

		} catch (InsufficientFundsException e) {
			e.printStackTrace();
		}
		
		
		bank.saveToFile();
		
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
