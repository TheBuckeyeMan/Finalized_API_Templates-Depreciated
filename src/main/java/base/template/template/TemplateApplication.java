package base.template.template;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import base.template.template.service.TemplateService;
import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class TemplateApplication implements CommandLineRunner{

	private final TemplateService templateService;

	public static void main(String[] args) {
		SpringApplication.run(TemplateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		templateService.get(); //Call API on Startup
		System.exit(0); //Exit API After API call is made
	}
}
