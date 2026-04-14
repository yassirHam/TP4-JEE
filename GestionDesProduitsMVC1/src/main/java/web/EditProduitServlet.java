package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;
import services.*;


/**
 * Servlet implementation class EditProduitServlet
 */
@WebServlet("/editProduit")
public class EditProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final produitMetier metier = produitMetierImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		Produit p = metier.getProduitById(id);
		request.setAttribute("produitEdit", p);
		request.setAttribute("listeProduits", metier.getAllProduits());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
