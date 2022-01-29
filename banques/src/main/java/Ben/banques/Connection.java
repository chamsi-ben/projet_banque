package Ben.banques;
import java.util.ArrayList;

public class Connection {


	/**
	 * @return the listeU
	 */
	public ArrayList<Utilisateur> getListeU() {
		return listeU;
	}

	/**
	 * @param listeU the listeU to set
	 */
	public void setListeU(ArrayList<Utilisateur> listeU) {
		this.listeU = listeU;
	}

	private ArrayList<Utilisateur> listeU;
	private Banque bank;
	public Connection(Banque bank) {
		listeU= new ArrayList<>();
		this.bank=bank;
	}

	public void ajout(String username, String mdp, String nom, String prenom, int age, String mail) {



		for(int i =0; i<listeU.size();i++) {
			if(listeU.get(i).getUsername()==username) {
				//System.out.println("erreur veuillez choisir un autre nom utilisateur");
				return;
			}		
		}

		double identifiant;

		boolean bon = false;
		do
		{
			identifiant = Math.random()*(10000-1);

			for(int i = 0;i<listeU.size();i++)
			{
				if(listeU.get(i).getIdentifiant() == identifiant)
				{
					bon = true;
				}
			}

		}while(bon);
		
		listeU.add(new Utilisateur(bank,(int)identifiant,username, mdp,nom, prenom,age, mail));
		
	}
	
	public void ajoutCompte(String username) {
		
		for(int i=0;i<listeU.size();i++) {
			if(listeU.get(i).getUsername().equals(username)) {
				listeU.get(i).ajoutcompt();
				
			}
		}
		
	}
	public ArrayList<Compte> afficheCompteUser(String username) {
		ArrayList<Compte> c = new ArrayList<>();
		for(int i =0;i<listeU.size();i++) {
			if(listeU.get(i).getUsername().equals(username)) {
				c = listeU.get(i).getComptes();
				return c;
			}
		}
		//System.out.println("aucun compte li�e a l username");
		return null;
	}
	
	
	public Utilisateur getUtilisateur(String username)
	{
		Utilisateur user;
		for(int i =0;i<listeU.size();i++) {
			if(listeU.get(i).getUsername().equals(username)) {
				user = listeU.get(i);
				return user;
			}
		}
		//System.out.println("aucun utilisateur li�e a l'username");
		return null;
	}
	
	public Utilisateur getUtilisateur(int idCompte)
	{
		Utilisateur user;
		for(int i =0;i<listeU.size();i++) {
			for(int j = 0;j<listeU.get(i).getComptes().size();j++)
			{
				if(listeU.get(i).getComptes().get(j).getIdentifiant() == idCompte) {
					user = listeU.get(i);
					return user;
				}
			}
			
		}
		//System.out.println("aucun utilisateur li�e a l'username");
		return null;
	}
	
	public boolean isExiste(String log)
	{
		if(log.length() == 0)
		{
			return false;
		}
		String[] tab = log.split("-");
		
		if(tab.length != 2) {
			return false;
		}
		
		for(int i = 0;i<listeU.size();i++)
		{
			if(tab[0].equals(listeU.get(i).getUsername()) && tab[1].equals(listeU.get(i).getMdp()))
			{
				return true;
			}
		}
		
		return false;
		
	}


}