

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Bank;

/**
 * Servlet implementation class SigninServlet
 */
@WebServlet("/SigninServlet")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bank bank = new Bank();
		bank.readFromFile();
		
		HttpSession session = request.getSession(true);
		session.setAttribute("bank", bank);
		
		String email = request.getParameter("signinEmail");
		String password = request.getParameter("signinPassword");
		RequestDispatcher rs = null;
		
		for (int x = 0; x < bank.customers.size(); x++) {
			if(email.equals(bank.customers.get(x).getEmail()) && password.equals(bank.customers.get(x).getPassword())) {
					session.setAttribute("customer", bank.customers.get(x));
					
					 rs = request.getRequestDispatcher("account.jsp");
					break;
			} else {
				//No match found
				System.out.println("Account not Found");
				rs = request.getRequestDispatcher("accountNotFound.jsp");
			}
		}
		rs.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
