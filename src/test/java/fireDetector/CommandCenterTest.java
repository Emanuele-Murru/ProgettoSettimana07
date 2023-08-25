package fireDetector;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommandCenterTest {
	
	private CommandCenter commandCenter;
	
	@BeforeEach
	public void setUp() {
		commandCenter = new CommandCenter(1L);
	}
	
	@Test
	public void smokeDetectorRegisterTest() {
		SmokeDetector smokeDetector = new SmokeDetector(1L, "52446", "44688", 0);
		commandCenter.register(smokeDetector);
		assertEquals(1, commandCenter.getSmokeDetectorList().size());
	}
	
	@Test
	public void notifyObserverTest() {
		SmokeDetector smokeDetector = new SmokeDetector(1L, "-48468", "-22345", 0);
		commandCenter.register(smokeDetector);
		commandCenter.notifyObserver();
		
		for (SmokeDetector s : commandCenter.getSmokeDetectorList()) {
			assertEquals(0, s.getSmokeLevel());
		}
	}
}
