package Ben.banques;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class BanqueClient {
	private static final Logger log = LoggerFactory.getLogger(BanqueClient.class);

	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpEntity<Banque> request = new HttpEntity<>(new Banque("banque1"));
		restTemplate.postForObject("http://localhost:8080/banque", request, Banque.class);
		
        List bq = restTemplate.getForObject("http://localhost:8080/banque", List.class);
        log.info(bq.toString());
        
	}

}
	
	
	

