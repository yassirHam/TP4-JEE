package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.user;
import dao.userDAO;
/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userDAO dao = new userDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		user u = dao.findByLoginAndPassword(login, password);
		if(u!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			if("admin".equals(u.getRole())) {
				response.sendRedirect("listProduits");
			}else {
				response.sendRedirect("listProduits");
			}
		}else {
			request.setAttribute("error", "login or pwd is incorrect");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
