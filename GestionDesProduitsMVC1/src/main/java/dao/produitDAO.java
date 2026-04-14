package dao;
import java.util.*;
import dao.Produit;

public interface produitDAO {
 
	public void addProduit(Produit p);
	public void deleteProduit(Long id);
	public void editProduit(Produit p);
	public void updateProduit(Produit p);
	public List<Produit> getAllProduits();
	public Produit getProduitById(Long ID);
	
	
}
