package projetoGenerico.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComponentConfig {

	@Value("${projetoGenerico.version}")
	private String projectVersion;

	public String getProjectVersion() {
		return projectVersion;
	}

}
