

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Address;
import com.user.Bank;
import com.user.CheckingAccount;
import com.user.Customer;
import com.user.SavingsAccount;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistrationServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	Bank bank = new Bank();
	bank.readFromFile();
		
	Customer customer = new Customer();
	customer.setEmail(request.getParameter("email"));
	customer.setFirstName(request.getParameter("firstName"));
	customer.setLastName(request.getParameter("lastName"));
	customer.setPassword(request.getParameter("password"));
	
	Address address = new Address();
	address.setCity(request.getParameter("city"));
	address.setState(request.getParameter("state"));
	address.setStreet(request.getParameter("street"));
	address.setZipcode(request.getParameter("zipcode"));
	
	CheckingAccount checkingAccount = new CheckingAccount();
	SavingsAccount savingsAccount = new SavingsAccount();
	checkingAccount.setBalance(Double.parseDouble(request.getParameter("initialDeposit")));
	
	customer.setAddress(address);
	customer.setCheckingAccount(checkingAccount);
	customer.setSavingsAccount(savingsAccount);
		
	bank.customers.add(customer);
	
	bank.saveToFile();
	
	HttpSession session = request.getSession(true);
	session.setAttribute("customer", customer);
	session.setAttribute("bank", bank);
	
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
