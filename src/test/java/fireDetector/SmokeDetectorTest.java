package fireDetector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeDetectorTest {
	
	private SmokeDetector smokeDetector;
	
	@BeforeEach
	public void setUp() {
		smokeDetector = new SmokeDetector(4L, "498464", "8949848", 0);
	}
	
	@Test
	public void smokeLevelControllerTest_Allarm() {
		smokeDetector.setSmokeLevel(7);
		smokeDetector.smokeLevelController();
		assertTrue(smokeDetector.getSmokeLevel() > 5);
	}
	
	@Test
	public void smokeLevControllerWithinLimitsTest() {
		smokeDetector.setSmokeLevel(2);
		smokeDetector.smokeLevelController();
		assertFalse(smokeDetector.getSmokeLevel() > 5);
	}
	
	@Test
	public void generateNotificationUrlTest() {
		smokeDetector.setSmokeLevel(3);
		String url = "http://host/alarm?idsmokedetector=4&lat=498464&lon=8949848&smokelevel=3";
		String generateUrl = smokeDetector.generateNotificationUrl();
		assertEquals(url, generateUrl);
	}
}
