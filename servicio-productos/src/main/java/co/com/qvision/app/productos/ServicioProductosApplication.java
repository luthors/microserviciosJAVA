package co.com.qvision.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServicioProductosApplication {

	public static void main(String[] args) {
		//System.setProperty("server.port", "8001");
		
		// o usar
        // System.getProperties().put("server.port", 8081);
		System.out.println(System.getProperty("server.port"));
		
		SpringApplication.run(ServicioProductosApplication.class, args);
	}

}
