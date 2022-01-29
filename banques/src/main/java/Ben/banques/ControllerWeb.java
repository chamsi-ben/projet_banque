package Ben.banques;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class ControllerWeb {
	
	
	@GetMapping("/seConnecter")
	public String testA()
	{
		return "seConnecter";
	}
	@GetMapping("/menuPrincipale")
	public String menu()
	{
		return "menuPrincipale";
	}
	
	@PostMapping("/test")
	public String connection()
	{
		
		boolean a = true;
	
		if(a)
		{	
			System.out.println("/menuPrincipale");
			return "redirect:/menuPrincipale";
		}else {
			//connec.getUtilisateur(tab[0]).setConnecter(false);
			System.out.println("au revoir");
			return "redirect:menuPrincipale";
		}
		
	}
}
