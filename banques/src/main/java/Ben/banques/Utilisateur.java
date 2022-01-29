package Ben.banques;
import java.util.ArrayList;

public class Utilisateur {

	
	private int identifiant;
	private String username;
	private String mdp;
	private ArrayList<Compte> comptes;
	private Proprietaire p;
	private String nom;
	private String prenom;
	private int age;
	private String mail;
	private Banque bank;
	private boolean connecter;

	public Utilisateur()
	{
		super();
	}
	
	public Utilisateur(Banque bank, int identifiant, String username, String mdp, String nom, String prenom, int age, String mail) 
	{
		super();
		this.bank=bank;
		this.identifiant=identifiant;
		this.username=username;
		this.mdp = mdp;
		this.nom=nom;
		this.prenom=prenom;
		this.age=age;
		this.mail=mail;
		this.comptes= new ArrayList<>();
		connecter = false;
		this.p= new Proprietaire(nom, prenom,age);
	}
	
	public void ajoutcompt()
	{
		
		double identifiant;
		boolean bon = false;
		do
		{
			identifiant = Math.random()*(80000-10000);
			
			for(int i = 0;i<bank.getBanque().size();i++)
			{
				if(bank.getBanque().get(i).getIdentifiant() == identifiant)
				{
					bon = true;
				}
			}
			
		}while(bon);
		Compte c = new Compte((int)identifiant, p,0);
		comptes.add(c);
		bank.ajoutCompte(c);
	}
	
	
	public String toString()
	{
		return "username : " + username +", mdp : " + mdp + ", nom : " +nom +", prenom : " + prenom + ", age : " +age+ ", mail : " + mail + ", identifiant : "+identifiant; 
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Banque getBank() {
		return bank;
	}

	public void setBank(Banque bank) {
		this.bank = bank;
	}

	public Compte getIdent() {
		
		
		
		return null;
		
	}

	/**
	 * @return the identifiant
	 */
	public int getIdentifiant() {
		return identifiant;
	}

	/**
	 * @param identifiant the identifiant to set
	 */
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * @return the comptes
	 */
	public ArrayList<Compte> getComptes() {
		return comptes;
	}

	/**
	 * @param comptes the comptes to set
	 */
	public void setComptes(ArrayList<Compte> comptes) {
		this.comptes = comptes;
	}

	/**
	 * @return the p
	 */
	public Proprietaire getP() {
		return p;
	}

	/**
	 * @param p the p to set
	 */
	public void setP(Proprietaire p) {
		this.p = p;
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setConnecter(boolean connect)
	{
		connecter = connect;
	}
	
	public boolean getConnecter() {
		return connecter;
	}

}
