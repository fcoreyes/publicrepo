package cl.tagprinter.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cl.tagprinter.server.queue.QueueManager;
import cl.tagprinter.server.queue.QueueManagerImpl;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Configuration
@EnableAutoConfiguration
public class TagPrinterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TagPrinterServiceApplication.class, args);
	}

	@Bean
	public QueueManager createQueueManager() {
		return new QueueManagerImpl();
	}
}
