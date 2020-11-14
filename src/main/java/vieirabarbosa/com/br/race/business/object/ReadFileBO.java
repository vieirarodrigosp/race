package vieirabarbosa.com.br.race.business.object;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import vieirabarbosa.com.br.race.DTO.LapDTO;
import vieirabarbosa.com.br.race.convert.Converts;

public class ReadFileBO {
	public static List<LapDTO> getReading(String file) throws IOException {
		List<LapDTO> laps;
		
		try (Stream fileLines = Files.lines(Paths.get(file), StandardCharsets.UTF_8)) {
			laps = (List<LapDTO>) fileLines.skip(1).map((Object line)->{
						try {
							return Converts.convertLineToLapDTO(correctingFile(line));
						} catch (ParseException e) { e.printStackTrace(); }
						return fileLines;})
					.collect(Collectors.toList());
		}
		
		return laps;
	}
	
	private static Object correctingFile(Object line) {
		while(line.toString().contains(";;")||line.toString().contains("  ")) {
			line = line.toString().replace("\t", ";");
			line = line.toString().replace(" – ", ";");
			line = line.toString().replace("  ", ";");
			line = line.toString().replace(";;", ";");
			line = line.toString().replace("; ", ";");
		}
		return line;
	}
}