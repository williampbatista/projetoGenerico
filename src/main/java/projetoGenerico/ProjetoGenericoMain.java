package projetoGenerico;

import java.nio.charset.Charset;

import org.apache.camel.spring.boot.CamelSpringBootApplicationController;
import org.apache.log4j.Logger;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableBatchProcessing
public class ProjetoGenericoMain extends SpringBootServletInitializer {
	
	private static final Logger LOG = Logger.getLogger(ProjetoGenericoMain.class);

	public static void main(String[] args) {

		System.setProperty("spring.config.name", "projetoGenerico-config");

		LOG.info("Charset.defaultCharset().name(): " + Charset.defaultCharset().name());

		SpringApplication app = new SpringApplication(ProjetoGenericoMain.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.setRegisterShutdownHook(false);

		ApplicationContext applicationContext = app.run(args);
		CamelSpringBootApplicationController applicationController = applicationContext
				.getBean(CamelSpringBootApplicationController.class);
		applicationController.run();
	}

//	public static void main(String[] args) throws Exception {
//		System.setProperty("spring.config.name", "projetoGenerico-config");
//		SpringApplication app = new SpringApplication(ProjetoGenericoMain.class);
//		app.setRegisterShutdownHook(false);
//
//		ApplicationContext applicationContext = app.run(args);
//		CamelSpringBootApplicationController applicationController = applicationContext.getBean(CamelSpringBootApplicationController.class);
//		applicationController.run();
//	}
}
