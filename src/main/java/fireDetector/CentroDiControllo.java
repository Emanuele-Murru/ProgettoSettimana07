package fireDetector;

import java.util.ArrayList;
import java.util.List;

import interfaces.Observer;
import interfaces.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CentroDiControllo implements Subject{
	
	private Long id;
	
	private List<Sonda> smokeDetectorList = new ArrayList<>();
	
	public CentroDiControllo(Long id) {
		this.id = id;
	}
	
	@Override
	public void register(Observer o) {
		smokeDetectorList.add((Sonda) o);
	}

	@Override
	public void notifyObserver() {
		System.out.println("Notify observer n " + id);
		for (Sonda s : smokeDetectorList) {
			s.smokeLevelController();
		}
	}
	
}
