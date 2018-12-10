

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

/**
 * Servlet implementation class CloseAccountServlet
 */
@WebServlet("/CloseAccountServlet")
public class CloseAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloseAccountServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		Bank bank = new Bank();
		bank = (Bank) session.getAttribute("bank");

		Customer customer = new Customer();
		customer = (Customer) session.getAttribute("customer");
				
		for (int x = 0; x < bank.customers.size(); x++) {
			if(customer.getEmail().equals(bank.customers.get(x).getEmail()) && customer.getPassword().equals(bank.customers.get(x).getPassword())) {
					session.setAttribute("customer", bank.customers.get(x));
					
					bank.customers.remove(x);
					
			}
		}
		
		bank.saveToFile();
		
		RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
		rs.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
