package vieirabarbosa.com.br.race.DTO;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LapDTO extends DriverDTO {
	public LapDTO(int code, String pilot) { super(code, pilot); }
	public Date hour;
	public int number;
	public Date time;
	public String averageTurnSpeed;
}