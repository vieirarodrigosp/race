package vieirabarbosa.com.br.race;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vieirabarbosa.com.br.race.business.object.RaceBO;

@SpringBootApplication
public class RaceApplication {
//	@Autowired
//	private static WinnerBO winnerBO;
	public static void main(String[] args) throws IOException {
		SpringApplication.run(RaceApplication.class, args);
		RaceBO.getWinner();
	}
}
