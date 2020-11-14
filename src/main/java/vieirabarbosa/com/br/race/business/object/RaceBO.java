package vieirabarbosa.com.br.race.business.object;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import vieirabarbosa.com.br.race.DTO.LapDTO;
import vieirabarbosa.com.br.race.DTO.WinnerDTO;
import vieirabarbosa.com.br.race.constants.Constant;

public class RaceBO {
	@Autowired
	private static WinnerBO winnerBO;
	public static void getWinner() throws IOException {
		List<LapDTO> race = ReadFileBO.getReading(Constant.path + "corrida.log");
		getOrderingPositions(race);
		winnerBO.getWinner(race).stream()
			.map((WinnerDTO winner)->{
				System.out.println(winner.getPosition() + winner.getLap().getCode() + " - "
					+ winner.getLap().getPilot() + " - Qtd de voltas completadas: "
					+ winner.getLap().getNumber() + " - tempo total de prova: "
					+ winner.getTotalTime() + " mm:ss.SSS");
			return winner;})
		.collect(Collectors.toList());
	}
	
	private static List<LapDTO> getOrderingPositions(List<LapDTO> race){
		Comparator<LapDTO> lapComparator = Comparator
				.comparing(LapDTO::getNumber).reversed()
				.thenComparing(LapDTO::getTime);
		race.sort(lapComparator);
		return race;
	}
}