package services;
import dao.*;
import java.util.*;

public class produitMetierImpl implements produitMetier{
	public static produitMetierImpl instance;
	private produitDAO dao;
	private produitMetierImpl() {
		dao = new produitImpl();
		((produitImpl) dao).init();	
	}
   public static produitMetierImpl getInstance() {
	   if(instance==null) {
		   instance = new produitMetierImpl();
	   }
	   return instance;
   }
   @Override	
   public void addProduit(Produit p) {
	   dao.addProduit(p);
   }
   @Override
	public void deleteProduit(Long id) {
		dao.deleteProduit(id);	
   }
	@Override
	public void editProduit(Produit p) {
		dao.editProduit(p);
	}
	@Override
	public void updateProduit(Produit p) {
		dao.updateProduit(p);
	}
	@Override
	public List<Produit> getAllProduits(){
		return dao.getAllProduits();
	}
	@Override
	public Produit getProduitById(Long ID) {
		return dao.getProduitById(ID);
	}
   
}
