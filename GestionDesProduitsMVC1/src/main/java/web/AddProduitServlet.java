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
 * Servlet implementation class AddProduitServlet
 */
@WebServlet("/addProduit")
public class AddProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final produitMetier metier = produitMetierImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String description = request.getParameter("description");
		Double prix = Double.parseDouble(request.getParameter("prix"));
		Produit p = new Produit(nom,description,prix);
		metier.addProduit(p);
		request.setAttribute("listeProduits", metier.getAllProduits());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
