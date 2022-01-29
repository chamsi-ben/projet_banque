package Ben.banques;
public class Proprietaire
{
	private String nom;
	private String prenom;
	private int age;
	private String categorie;
	
	public Proprietaire()
	{
		super();
		
		if(age < 26)
		{
			categorie = "jeune";
			return;
		}
		if(age < 65)
		{
			categorie = "adulte";
		}
		if(age > 65)
		{
			categorie = "retraite";
		}
		
	}
	
	public Proprietaire(String nom, String prenom, int age)
	{
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		
		if(age < 26)
		{
			categorie = "jeune";
			return;
		}
		if(age < 65)
		{
			categorie = "adulte";
		}
		if(age > 65)
		{
			categorie = "retraite";
		}
		
	}

	public String getNom() 
	{
		return nom;
	}

	public void setNom(String nom) 
	{
		this.nom = nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getCategorie() 
	{
		return categorie;
	}

	public void setCategorie(String categorie) 
	{
		this.categorie = categorie;
	}
	
	
	
	
}
