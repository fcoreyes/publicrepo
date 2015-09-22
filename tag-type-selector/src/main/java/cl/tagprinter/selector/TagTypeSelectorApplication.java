package cl.tagprinter.selector;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import jline.ConsoleReader;

@SpringBootApplication
public class TagTypeSelectorApplication implements CommandLineRunner {

	@Value("${tag.printer.server.url}")
	private String serviceUrl;

	private RestTemplate template = new RestTemplate();

	public static void main(String[] args) throws IOException {
		SpringApplication.run(TagTypeSelectorApplication.class, args);
	}

	public void run(String... args) throws IOException {

		ConsoleReader consoleReader = new ConsoleReader();

		while (true) {
			System.out.println("Enter Tag Type: ");
			char input = (char) consoleReader.readCharacter("1234567890".toCharArray());

			System.out.println("Calling " + serviceUrl + "/" + input);
			try {
				template.postForLocation(serviceUrl + "/{type}" + input, null, "" + input);
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}
}
