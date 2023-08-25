package fireDetector;

import interfaces.Observer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Sonda implements Observer{
	private Long id;
	private String latitude;
	private String longitude;
	private Integer smokeLevel;
	private CentroDiControllo centroControllo;
	
	public Sonda(Long id,String latitude, String longitude, Integer smokeLevel) {
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.smokeLevel = smokeLevel;
	}

	@Override
	public void smokeLevelController() {
		
		if(this.smokeLevel > 5) {
			String notificatorUrl = generateNotificationUrl();
			System.out.println("EMERGENCY ALARM! The smoke detector " + id + " has detected a smoke level of " + smokeLevel + " at latitude: " + latitude + " and longitude: " + longitude);
			System.out.println("\n The command center sents the URL notification" + notificatorUrl);
			System.out.println("----------------------------------------------------------------------------------------------");
		} else {
			System.out.println();
			System.out.println("The smoke detector n " + id + " didn't detect any anomaly");
		}
	}
	
	public String generateNotificationUrl() {
		return "http://host/alarm?=idsonda=" + id + "&lat=" + latitude + "&lon=" + longitude + "smokeLevel=" + smokeLevel;
	}
}
