package fireDetector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProgettoSettimana07Application {

	public static void main(String[] args) {
		SpringApplication.run(ProgettoSettimana07Application.class, args);
		
		SmokeDetector s1 = new SmokeDetector(1L, "48464", "86846", 4);
		SmokeDetector s2 = new SmokeDetector(2L, "-89994", "34842", 12);
		SmokeDetector s3 = new SmokeDetector(3L, "13546", "-47853", 5);
		SmokeDetector s4 = new SmokeDetector(4L, "-45486", "48321", 0);
		SmokeDetector s5 = new SmokeDetector(5L, "-66485", "-48441", 8);
		
		
		CommandCenter c1 = new CommandCenter(434255428L);
		c1.register(s1);
		c1.register(s2);
		c1.register(s3);
		
		CommandCenter c2 = new CommandCenter(84694355L);
		c2.register(s4);
		
		CommandCenter c3 = new CommandCenter(1535421L);
		c3.register(s5);
		
		c1.notifyObserver();
		c2.notifyObserver();
		c3.notifyObserver();
	}

}
