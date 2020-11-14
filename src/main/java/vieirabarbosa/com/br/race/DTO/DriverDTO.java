package vieirabarbosa.com.br.race.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
abstract class DriverDTO {
	public int code;
	public String pilot;
}