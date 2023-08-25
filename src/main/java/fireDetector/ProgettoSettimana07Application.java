package fireDetector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProgettoSettimana07Application {

	public static void main(String[] args) {
		SpringApplication.run(ProgettoSettimana07Application.class, args);
		
		Sonda s1 = new Sonda(1L, "48464", "86846", 4);
		Sonda s2 = new Sonda(2L, "-89994", "34842", 12);
		Sonda s3 = new Sonda(3L, "13546", "-47853", 5);
		Sonda s4 = new Sonda(4L, "-45486", "48321", 0);
		Sonda s5 = new Sonda(5L, "-66485", "-48441", 8);
		
		
		CentroDiControllo c1 = new CentroDiControllo(434255428L);
		c1.register(s1);
		c1.register(s2);
		c1.register(s3);
		
		CentroDiControllo c2 = new CentroDiControllo(84694355L);
		c2.register(s4);
		
		CentroDiControllo c3 = new CentroDiControllo(1535421L);
		c3.register(s5);
		
		c1.notifyObserver();
		c2.notifyObserver();
		c3.notifyObserver();
	}

}
