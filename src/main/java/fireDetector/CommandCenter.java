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
public class CommandCenter implements Subject{
	
	private Long id;
	
	private List<SmokeDetector> smokeDetectorList = new ArrayList<>();
	
	public CommandCenter(Long id) {
		this.id = id;
	}
	
	@Override
	public void register(Observer o) {
		smokeDetectorList.add((SmokeDetector) o);
	}

	@Override
	public void notifyObserver() {
		System.out.println("Notify observer n " + id);
		for (SmokeDetector s : smokeDetectorList) {
			s.smokeLevelController();
		}
	}
	
}
