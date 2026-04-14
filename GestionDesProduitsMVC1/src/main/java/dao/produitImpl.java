package dao;
import dao.*;
import java.util.*;

public class produitImpl  implements produitDAO{
    private List<Produit> products = new ArrayList<>();
    public void init() {
    	System.out.println("Spring IOC est bien fctt!!");
    	addProduit(new Produit("PC 1","Sony vaio 1",7000.0));
    	addProduit(new Produit("PC 2","Sony vaio 2",6000.0));
    }
    public void addProduit(Produit p) {
    	p.setIdProduit(new Long(products.size()+1));
    	products.add(p);
    }
    public void deleteProduit(Long id) {
    	products.remove(getProduitById(id));
    }
    public Produit getProduitById(Long id) {
    	for(Produit p : products) {
    		if(p.getIdProduit().equals(id))
    			return p;
    	}
    	return null;
    }
    public List<Produit> getAllProduits(){
    	return products;
    }
    public void updateProduit(Produit p) {
    	for(int i=0 ; i<products.size() ; i++) {
    		Produit existingProduct = products.get(i);
    		if(existingProduct.getIdProduit().equals(p.getIdProduit())) {
    			existingProduct.setNom(p.getNom());
    			existingProduct.setDescription(p.getDescription());
    			existingProduct.setPrix(p.getPrix());
    			break;
    		}
    	}
    }
	@Override
	public void editProduit(Produit p) {
		// TODO Auto-generated method stub
		
	}
}
