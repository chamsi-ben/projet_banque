package Ben.banques;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BanqueService {

	
	private Banque b = new Banque("Bank");
	private Connection connec = new Connection(b);
	private boolean succeslog = false;
	private String dernierCo;
	
	public BanqueService() {
		
		
		connec.ajout("callou", "azerty", "ben", "chamsi", 21, "ben@hotmail.fr");
		connec.ajout("chi", "123456", "ben", "chiheb", 21, "benchi@hotmail.fr");
		
		connec.ajoutCompte("callou");
		connec.ajoutCompte("chi");
	}
	
	
	@GetMapping("/")
    public String menuPrincip(){
        return "menuPrincipale";
    }
	
	/**
	 * Permet d'envoyer des infos de java à hmtl avec model
	 * @param model
	 * @return
	 */
	@GetMapping("/seConnect")
	public String seConnecter(Model model) {	
		Login log = new Login();
		model.addAttribute("log", log);
		return "seConnecter";
	}
	
	@GetMapping("/Inscrip")
	public String Inscription() {
		return "Inscription";
	}
	
	@GetMapping(value = "/comptes/vu/{username}")
	public ArrayList<Compte> getListProp(@PathVariable("username")String u){
		return connec.afficheCompteUser(u);
		
	}
	
	@PostMapping("/comptes")
	public void ajoutCompt(@RequestBody String username) throws Exception{
		connec.ajoutCompte(username);
	}
	
	@PutMapping(value = "/comptes/ajoute/{identifiant}")
	public void vire(@PathVariable("identifiant") int id,
					@RequestParam(value="montant", required = true)float mont) {
		
		for(int i =0;i<b.getBanque().size();i++) {
			b.getBanque().get(i).ajoutMontant(mont,id);
			
		}
		
	}
	
	@PutMapping(value = "/comptes/retire/{identifiant}")
	public void reti(@PathVariable("identifiant") int id,
					@RequestParam(value="montant", required = true)float mont) {
		
		for(int i =0;i<b.getBanque().size();i++) {
			b.getBanque().get(i).retirerMontant(mont,id);
			
		}
		
	}
			
	
	@PostMapping("/comptes/creation")
	public String creationUtilisateur(@RequestBody Utilisateur user)
	{
		connec.ajout(user.getUsername(), user.getMdp(), user.getNom(), user.getPrenom(), user.getAge(), user.getMail());

		return "redirect:/seConnect";
		
		
	}
	
	/**
	 * verifie les log obtenu  grace au modelAttribute envoyé précedement dans la méthode seConnecter
	 * @param log
	 * @return
	 */
	@PostMapping("/comptes/connection")
	public String connection(@ModelAttribute("log") Login log)
	{
		Utilisateur user;
		if(log.log() == null)
		{
			return "redirect:/menuPrincpale";
		}
		//String log = "callou-azerty";
		String[] tab = log.log().split("-");
		
		if(tab.length != 2)
		{
			return "redirect:/menuPrincipale";
			//return null;
		}
		
		succeslog = connec.isExiste(log.log());
		if(connec.isExiste(log.log()))
		{	
			connec.getUtilisateur(tab[0]).setConnecter(true);
			dernierCo = connec.getUtilisateur(tab[0]).getUsername();
			return "redirect:/connection/"+connec.getUtilisateur(tab[0]).getUsername();//redirige vers la methode connection (GET) avec l'username
		}else {
	

			return "redirect:/menuPrincipale";
		}
		
	}
	
	
	/**
	 * Depuis la méthode au dessus (connection), elle permet d'envoyer des information de java à html
	 * @param user
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/connection/{username}")
	public String connection(@PathVariable("username") String user, Model model)
	{
		Utilisateur username = connec.getUtilisateur(user);
		model.addAttribute("user", username);
		return "connecter";
	}
	
	/**
	 * De html à java, lors de l'excecution du boutton, on ajoute un compte en fonction de l'username
	 * @param username
	 * @param user
	 * @return
	 */
	@PostMapping("/connection/ajoutComptes/{username}")
	public String ajoutCompte(@PathVariable String username,@ModelAttribute("user") Utilisateur user)
	{
		connec.getUtilisateur(user.getUsername()).ajoutcompt();
		return "redirect:/connection/"+connec.getUtilisateur(user.getUsername()).getUsername();
	}
	
	/**
	 * de html à java : redirige vers la méthode afficheCompte pour afficher en html
	 * @param user
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/connection/comptes/{username}")
	public String afficheComptes(@PathVariable("username") String user,Model model)
	{
		return "redirect:/affiche/"+connec.getUtilisateur(user).getUsername();
	}
	
	/**
	 * java à html: on envoi les informations de l'utilisateur pour pouvoir les afficher
	 * @param user
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/affiche/{username}")
	public String afficheCompte(@PathVariable("username") String user, Model model)
	{	
		model.addAttribute("comptes", connec.getUtilisateur(user).getComptes());
		model.addAttribute("user", connec.getUtilisateur(user));
		return "afficheComptes";
	}
	
	/**
	 * java à html, permet d'accés à la modification du compte en envoyant en attribut le compte correspont à l'identifiant
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/connection/comptes/modif/{identifiant}")
	public String modifCompte(@PathVariable("identifiant") int id, Model model)
	{
		Compte compte = b.recupCompte(id);
		Utilisateur user = connec.getUtilisateur(id);
		model.addAttribute("compte", compte);
		model.addAttribute("user", user);
		
		return "modifCompte";
	}
	
	@PostMapping(value = "/ajoutMontant/{identifiant}")
	public String ajoutMontant(@PathVariable("identifiant") String user,@ModelAttribute("compte") Compte c)
	{
		System.out.println("montant" + c);
		System.out.println("montant" + c.getAjoutMontant());
		b.recupCompte(c.getIdentifiant()).ajoutMontant(c.getAjoutMontant(), c.getIdentifiant());
		b.recupCompte(c.getIdentifiant()).setAjoutMontant(0);
		return "redirect:/connection/comptes/modif/"+user;
	}
	
	@PostMapping(value = "/deconnection/{username}")
	public String deconnection(@ModelAttribute("user") Utilisateur user)
	{
		connec.getUtilisateur(user.getUsername()).setConnecter(false);
		return "redirect:/seConnect";
	}
	
	
	@PostMapping(value = "/virement/{identifiant}")
	public String virement(@PathVariable("identifiant") String user,@ModelAttribute("compte") Compte c)
	{	
		b.recupCompte(c.getIdentifiant()).virementArgent(b.recupCompte(c.getIdVirement()), c.getMontantVirement());
		b.recupCompte(c.getIdentifiant()).setAjoutMontant(0);
		return "redirect:/connection/comptes/modif/"+user;
	}
	

}
