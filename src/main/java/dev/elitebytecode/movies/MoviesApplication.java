package dev.elitebytecode.movies;
// Step 1
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@RestController
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}
	 // Annotation from Rest-Controller Used to tell the framework the route's return values
	//	@GetMapping("/")
	//	public String apiRoot(){
	//	return "Hello World!";
	//	}

}
