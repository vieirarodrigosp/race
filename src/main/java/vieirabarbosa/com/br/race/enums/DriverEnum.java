package vieirabarbosa.com.br.race.enums;

public enum DriverEnum {
	P038("F.MASSA"),
	P033("R.BARRICHELLO"),
	P002("K.RAIKKONEN"),
	P023("M.WEBBER"),
	P015("F.ALONSO");
	private String pilot;
	public String getPilot() { return pilot; }
	DriverEnum(String pilot) { this.pilot = pilot; }
}