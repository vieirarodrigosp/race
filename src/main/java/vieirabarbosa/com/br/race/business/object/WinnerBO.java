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
		List<WinnerDTO> winners = new ArrayList<WinnerDTO>();
		int maxNumberLaps = getMaxNumberLaps(race);
//		LapDTO qtdLaps = race.stream().filter(lap -> lap.number == 4).count().max(Comparator.comparing(LapDTO::getNumber)).get();
//		long count = race.stream().filter(lap -> lap.getNumber() == 4 ).count();
//		race.stream().max(Comparator.comparing(LapDTO::getNumber)).count();
//		winners.addAll(race.stream().filter(lap -> lap.number == maxNumberLaps).collect(Collectors.toList()));
//		int i = Math.toIntExact(getNumberPilots(race, maxNumberLaps));
//		while(i!=0) {
//			int maxNumberLaps = maxNumberLaps;
//			i--;
//		}
//		winners.stream()
//			.limit(Long.valueOf(maxNumberLaps))
//			.map((WinnerDTO newWinner)-> {
//				return getWinnerDTO(race, maxNumberLaps);})
//			.collect(Collectors.toList());
//		winners.add(getWinnerDTO(race, maxNumberLaps));
		//		winners = winners.stream()
//			.map((WinnerDTO winner) -> {
//				WinnerDTO newWinner =  WinnerDTO.builder().build();
//				newWinner.se
//				race.stream()
//					.filter(lap -> lap.number == maxNumberLaps)
//					.map((LapDTO lap) -> {
//						winner.setLap(lap);
//						return lap;})
//					.collect(Collectors.toList());
				
//				return winner;})
//			.collect(Collectors.toList());
//		List<LapDTO> raceTest1 = race.stream().filter(lap -> lap.number == maxNumberLaps).collect(Collectors.toList());
//		Stream<LapDTO> raceTest2 = race.stream().sequential();
//		List<String> position = new ArrayList<String>();
//		position.add("Primera posição: ";"Segunda posição: ";"Terceira posição: ";"Quarta posição: ";"Quinta posição: "}););
		addWinnerToList(race, winners, maxNumberLaps);
		return winners;
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
	private static void addWinnerToList(List<LapDTO> race, List<WinnerDTO> winners, int maxNumberLaps) {

//		ArrayList<String> positions = new ArrayList<>(Arrays.asList("Primera posição: ","Segunda posição: ","Terceira posição: ","Quarta posição: ","Quinta posição: "));
//		WinnerDTO winner =  WinnerDTO.builder().build();
//		race.stream()
//		.filter(lap -> lap.number == maxNumberLaps)
//		.map((LapDTO lap) -> {
//			winner.setLap(lap);
//			return lap;})
//		.collect(Collectors.toList());
//		return winner;
		race.stream()
			.filter(lap -> lap.number == maxNumberLaps)
			.map((LapDTO lap) -> {
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
//
//				positions.stream()
//					.map((String position)-> {
//						winners.add(WinnerDTO.builder().lap(lap).position(position.in).build());
//			//			winners.add(position);
//			//			winner.setPosition(position);
//						return position;})
//					.collect(Collectors.toList());
				
				
				
//				positions.stream().map((String position)->{return }
				addPositionToList(lap, winners, race);
				return lap;})
			.collect(Collectors.toList());
	}
	private static void addPositionToList(LapDTO lap, List<WinnerDTO> winners, List<LapDTO> race) {
//		List<String> positions = new ArrayList<WinnerDTO>();
//		ArrayList<String> positions = new ArrayList<>(
		List<String> positions = new ArrayList<>(
				Arrays.asList("Primera posição: ","Segunda posição: ","Terceira posição: ","Quarta posição: ","Quinta posição: "));
		winners.stream()
			.map((WinnerDTO winner)-> {
				winner.setPosition(positions.get(winners.indexOf(winner)));
				
//				positions.get(winners.indexOf(winner));
//			positions.iterator();
//			winner.setPosition(positions.iterator().toString());
//			.findFirst()
//			.limit(1)
//			.map((String position)-> {
				
//				winners.add(WinnerDTO.builder().lap(lap).position(position).build());
	//			winners.add(position);
//				winner.setPosition(position);
//				return position;})
//			.collect(Collectors.toList());
//					for(String position : positions) {
//						winner.setPosition(position);
//					}
//				IntStream.range(0, positions.size())
//				positions.stream()
//				.filter(i -> positions[i].length() <= i)
//		         .mapToObj(i -> positions[i])
//		         .collect(Collectors.toList());
//				positions.stream()
//				positions.stream().findAny().get();
				return winner;})				
			.collect(Collectors.toList());
//		for(WinnerDTO winner : winners) {
//			winners.indexOf(winner)
//			for(String position : )
//		}
	}
}