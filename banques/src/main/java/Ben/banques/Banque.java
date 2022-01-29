package Ben.banques;

import java.util.ArrayList;

public class Banque {

	private String nom;
	private ArrayList<Compte> banque;
	
	public Banque(String nom)
	{
		this.nom = nom;
		banque = new ArrayList<Compte>();
	}
	
	public ArrayList<Compte> recupCompte(Proprietaire p)
	{
		ArrayList<Compte> comptes = new ArrayList<>();
		for(int i = 0; i<banque.size(); i++)
		{
			if(p.getPrenom().equals(banque.get(i).getP().getPrenom()) && p.getNom().equals(banque.get(i).getP().getNom()))
			{
				comptes.add(banque.get(i));
			}
		}
		
		if(comptes.size() == 0)
		{
			//System.out.println("Aucun compte existant dans la banque " + nom);
			return null;
		}
		
	    return comptes;
			
	}
	
	public Compte recupCompte(int id)
	{
		for(int i = 0; i<banque.size(); i++)
		{
			if(id == banque.get(i).getIdentifiant())
			{
				return banque.get(i);
			}
		}
		//System.out.println("Le compte n'existe pas");
		return new Compte();
	}
	
	public void ajoutCompte(Compte c)
	{	
		banque.add(c);
	}
	
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the banque
	 */
	public ArrayList<Compte> getBanque() {
		return banque;
	}

	/**
	 * @param banque the banque to set
	 */
	public void setBanque(ArrayList<Compte> banque) {
		this.banque = banque;
	}

	public void fermerCompte(int ident) 
	{
		
		for(int i=0;i<banque.size();i++) 
		{
			if(banque.get(i).getIdentifiant() == ident)
			{
				banque.remove(i);
				return;
			}
		}
		
		//System.out.println("aucun compte ne possede cet identifiant l�!");
		
		
	}
	
	
	
	
	
}
