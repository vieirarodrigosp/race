package vieirabarbosa.com.br.race.business.object;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vieirabarbosa.com.br.race.DTO.LapDTO;
import vieirabarbosa.com.br.race.DTO.WinnerDTO;
import vieirabarbosa.com.br.race.constants.Constant;

@Component
public class RaceBO {
	@Autowired
	private WinnerBO winnerBO;
	public String getWinner(String file) throws IOException {
		List<LapDTO> race = ReadFileBO.getReading(Constant.path + file);
		getOrderingPositions(race);
		winnerBO.getWinner(race).stream()
			.map((WinnerDTO winner)->{
				System.out.println(winner.getPosition() + winner.getLap().getCode() + " - "
					+ winner.getLap().getPilot() + " - Qtd de voltas completadas: "
					+ winner.getLap().getNumber() + " - tempo total de prova: "
					+ winner.getTotalTime() + " mm:ss.SSS");
			return winner;})
		.collect(Collectors.toList());
		return "-1";
	}
	
	private List<LapDTO> getOrderingPositions(List<LapDTO> race){
		Comparator<LapDTO> lapComparator = Comparator
				.comparing(LapDTO::getNumber).reversed()
				.thenComparing(LapDTO::getTime);
		race.sort(lapComparator);
		return race;
	}
}