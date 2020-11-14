package vieirabarbosa.com.br.race.DTO;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WinnerDTO {
	public String position;
	public LapDTO lap;
	public Date startTime;
	public Date endTime;
	public String totalTime;
}