package projetoGenerico.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projetoGenerico.config.ComponentConfig;
@RestController
@RequestMapping("/health")
public class Health {
	
	ComponentConfig componentConfig;
	
	
	
	public String health() {
		return componentConfig.getProjectVersion();
	}

}
