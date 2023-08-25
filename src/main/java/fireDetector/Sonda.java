package fireDetector;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Sonda {
	private Long id;
	private String latitudine;
	private String longitudine;
	private Integer smokeLevel = 0;
	private CentroDiControllo centroControllo;
	
	public Sonda(Long id,String latitudine, String longitudine, Integer smokeLevel) {
		this.id = id;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.smokeLevel = smokeLevel;
	}
	
}
