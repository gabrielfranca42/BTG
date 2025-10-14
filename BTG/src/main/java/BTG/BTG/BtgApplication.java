package BTG.BTG;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"BTG.BTG", "model"})
public class BtgApplication {

	public static void main(String[] args) {
		SpringApplication.run(BtgApplication.class, args);
	}

}
