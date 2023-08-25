package fireDetector;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SmokeDetectorTest {
	
	private SmokeDetector smokeDetector;
	
	@BeforeEach
	public void setUp() {
		smokeDetector = new SmokeDetector(1645468L, "498464", "8949848", 0);
	}
	
	@Test
	public void testControlloLivelloFumo_Allarme() {
		smokeDetector.setSmokeLevel(7);
		smokeDetector.smokeLevelController();
		assertTrue(smokeDetector.getSmokeLevel() > 5);
	}
	

}
