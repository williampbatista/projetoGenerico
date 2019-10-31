package projetoGenerico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projetoGenerico.resource.CustomerResource;
import projetoGenerico.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService service;

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private JmsTemplate jmsTemplateTopic;

	@PostMapping(value = { "", "/" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CustomerResource> save(@RequestBody CustomerResource resource) {
		service.save(resource);
		return new ResponseEntity<CustomerResource>(resource, HttpStatus.CREATED);
	}

	@GetMapping({ "", "/" })
	public String findAll(Pageable pageable) {
//		jmsTemplate.convertAndSend("queue.presida", String.class);

//		return (String) jmsTemplate.receiveAndConvert("queue.presida");
return null;
//		jmsTemplateTopic.convertAndSend("topic.sample", "MENSAGEM");
//		return service.findAll();
	}
}
