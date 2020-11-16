package vieirabarbosa.com.br.race;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vieirabarbosa.com.br.race.business.object.RaceBO;

@SpringBootApplication
public class RaceApplication {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(RaceApplication.class, args);
		RaceBO raceBO = new RaceBO();
		raceBO.getWinner("corrida.log");
	}
}