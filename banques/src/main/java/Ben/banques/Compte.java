package Ben.banques;
import java.util.ArrayList;

public class Compte {
	
	private int identifiant;
	private Proprietaire p;
	private double montant;
	private double ajoutMontant;
	private double montantVirement;
	private int idVirement;
	
	public double getMontantVirement() {
		return montantVirement;
	}

	public void setMontantVirement(double montantVirement) {
		this.montantVirement = montantVirement;
	}

	public Compte()
	{
		super();
	}
	
	public Compte(double ajoutMontant)
	{
		super();
		this.ajoutMontant = ajoutMontant; 
	}
	
	public Compte(int ind, Proprietaire p, double mont)
	{
		super();
		identifiant = ind; //rappel : faut voir si l'identifiant a et� donn� ou pas
		this.p = p;
		this.montant = mont;
		ajoutMontant = 0;
		montantVirement = 0;
		idVirement=0;
	}
	

	public int getIdVirement() {
		return idVirement;
	}

	public void setIdVirement(int idVirement) {
		this.idVirement = idVirement;
	}

	public void ajoutMontant(double argent,int ident)
	{
		/*for(int i=0; i<comptes.size();i++) {
			if(comptes.get(i).getIdentifiant() == ident) {
				montant+= argent;
			}
		}*/
		if(ident == identifiant) {
			montant+= argent;
		}
		
	}
	
	public void retirerMontant(double argent, int ident)
	{
		if((montant - argent) < 0)
		{
			//System.out.println("Pas assez d'argent dans le compte");
			return;
		}
		if(ident == identifiant) {
			montant-= argent;
		}
	}
	
	public void virementArgent(Compte compte, double argent)
	{
		if(compte.getIdentifiant() == identifiant)
		{
			//System.out.println("impossible entre meme deux identifiant");
			return;
		}
		
		if((montant - argent) > 0)
		{
			retirerMontant(argent, identifiant);
			compte.ajoutMontant(argent, compte.getIdentifiant());
		}
		
	}
	

	public String toString()
	{
		return "identifiant : " + identifiant+ " Nom : " + p.getNom()+" Prenom : " + p.getPrenom()+" Montant : " + montant+ "\n";
	}
	
	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public Proprietaire getP() {
		return p;
	}

	public void setP(Proprietaire p) {
		this.p = p;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public double getAjoutMontant() {
		return ajoutMontant;
	}

	public void setAjoutMontant(double ajoutMontant) {
		this.ajoutMontant = ajoutMontant;
	}
	
	
}
