package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import dao.*;
import services.produitMetierImpl;

/**
 * Servlet implementation class ListProduitServlet
 */
@WebServlet("/listProduits")
public class ListProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static produitMetierImpl metier = produitMetierImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idProduit= request.getParameter("idProduit");
		List<Produit> liste = new ArrayList<>();
		
		if(idProduit != null && !idProduit.isEmpty()) {
			try {
				Long id = Long.parseLong(idProduit);
				Produit p = metier.getProduitById(id);
				if(p!=null) {
					liste.add(p);
				}
			}catch(NumberFormatException e){
				liste = metier.getAllProduits();		
				}
		}else {
			liste = metier.getAllProduits();
	    }

		request.setAttribute("listeProduits", liste);
		HttpSession session = request.getSession(false);
		user u = (user) session.getAttribute("user");
		if(u!=null && "admin".equals(u.getRole())) {
		    request.getRequestDispatcher("index.jsp").forward(request,response);
        }else {
        	request.getRequestDispatcher("list.jsp").forward(request, response);
        }
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
