package vieirabarbosa.com.br.race.business.object;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import vieirabarbosa.com.br.race.DTO.LapDTO;
import vieirabarbosa.com.br.race.DTO.WinnerDTO;
import vieirabarbosa.com.br.race.convert.Converts;

public class WinnerBO {
	public static List<WinnerDTO> getWinner(List<LapDTO> race) {
		return raceToLaps(race, getMaxNumberLaps(race));
	}	
	public static int getMaxNumberLaps(List<LapDTO> race) {
		return race.stream().max(Comparator.comparing(LapDTO::getNumber)).get().number;
	}
	public static long getNumberPilots(List<LapDTO> race, int maxNumberLaps) {
		return race.stream().filter(lap -> lap.getNumber() == maxNumberLaps ).count();
	}
	public static Date getMaxHour(List<LapDTO> race, int code) {
		return race.stream().filter(lap -> lap.code == code ).max(Comparator.comparing(LapDTO::getHour)).get().hour;
	}
	public static Date getMinHour(List<LapDTO> race, int code) {
		return race.stream().filter(lap -> lap.code == code ).min(Comparator.comparing(LapDTO::getHour)).get().hour;
	}
	private static List<WinnerDTO> raceToLaps(List<LapDTO> race, int maxNumberLaps) {
		List<WinnerDTO> winners = new ArrayList<WinnerDTO>();

		race.stream()
			.filter(lap -> lap.number == maxNumberLaps)
			.map((LapDTO lap) -> {
				addWinnerToList(lap, winners, race);
				return lap;})
			.collect(Collectors.toList());
		
		return winners;
	}
	private static void addWinnerToList(LapDTO lap, List<WinnerDTO> winners, List<LapDTO> race) {
		Date maxHour = getMaxHour(race, lap.getCode());
		Date minHour = getMinHour(race, lap.getCode());
		Date totalHour = new Date(maxHour.getTime() - minHour.getTime());

		try {
			winners.add(
					WinnerDTO.builder()
						.lap(lap)
						.startTime(minHour)
						.endTime(maxHour)
						.totalTime(Converts.convertDateFormat(totalHour))
					.build());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		addPositionToList(lap, winners, race);
	}
	private static void addPositionToList(LapDTO lap, List<WinnerDTO> winners, List<LapDTO> race) {
		List<String> positions = new ArrayList<>(
				Arrays.asList("Primera posição: ","Segunda posição: ","Terceira posição: ","Quarta posição: ","Quinta posição: "));
		
		winners.stream()
			.map((WinnerDTO winner)-> {
					winner.setPosition(positions.get(winners.indexOf(winner)));
				return winner;})				
			.collect(Collectors.toList());
	}
}