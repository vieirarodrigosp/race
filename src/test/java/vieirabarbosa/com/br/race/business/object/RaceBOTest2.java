package vieirabarbosa.com.br.race.business.object;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class RaceBOTest2 {
	@Test
	void testGetWinner() throws IOException {
		RaceBO raceBO = new RaceBO();
		String returnGetWinner = raceBO.getWinner("corridaMock.log");
		assertEquals("-1", returnGetWinner);
	}

}
