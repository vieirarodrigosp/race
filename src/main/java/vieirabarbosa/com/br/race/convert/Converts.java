package vieirabarbosa.com.br.race.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import vieirabarbosa.com.br.race.DTO.LapDTO;

public class Converts {
	public static LapDTO convertLineToLapDTO(Object line) throws ParseException {
		String[] convertedRowsToColumns = line.toString().split(";");
		
		LapDTO lap = new LapDTO(0, null);
		
		for(int i =0; i < convertedRowsToColumns.length; i++){
			switch (i) {
			case 0:
				lap.setHour(convertStringToDate(convertedRowsToColumns[i],i));
				break;
			case 1:
				lap.setCode(Integer.valueOf(convertedRowsToColumns[i]));
				break;
			case 2:
				lap.setPilot(convertedRowsToColumns[i]);
				break;
			case 3:
				lap.setNumber(Integer.valueOf(convertedRowsToColumns[i]));
				break;
			case 4:
				lap.setTime(convertStringToDate(convertedRowsToColumns[i],i));
				break;
			case 5:
				lap.setAverageTurnSpeed(convertedRowsToColumns[i]);
				break;
			}
		}
		return lap;
	}
	
	public static Date convertStringToDate(String date, int i) throws ParseException {
		SimpleDateFormat formatter;
		if(i == 4)
			formatter = new SimpleDateFormat("mm:ss.SSS");	
		else
			formatter = new SimpleDateFormat("HH:mm:ss.SSS");
		Date convertedDate = formatter.parse(date);
		return convertedDate;
	}
	
	public static String convertDateFormat(Date date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("mm:ss.SSS");
		String formatted = formatter.format(date);
		return formatted;
	}
}
