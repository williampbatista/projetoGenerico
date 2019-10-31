package projetoGenerico.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import projetoGenerico.converter.CustomerConverter;
import projetoGenerico.entity.Customer;
import projetoGenerico.repository.CustomerRepository;
import projetoGenerico.resource.CustomerResource;

@Component
public class CustomerService {

	private static final Logger LOG = Logger.getLogger(CustomerService.class);

	@Autowired
	CustomerRepository customerRepository;

	public void save(CustomerResource resource) {
		customerRepository.save(CustomerConverter.toEntity(resource));
	}
	
	public List<CustomerResource> findAll() {
		List<CustomerResource> listCustomer = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			listCustomer.add(new CustomerResource(i, "NOME", "EMAIL", "MOTHERNAME", new Date(), "CPF", "RG", "PASSWORD",
					"PHONE", Boolean.TRUE));
		}

		return listCustomer;

//		return CustomerConverter.toListResource(customerRepository.findAll());
	}
	
	
	@JmsListener(destination = "queue.presida")
	public String findAllPresida() {
		LOG.info("TESTE");
		List<CustomerResource> listCustomer = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			listCustomer.add(new CustomerResource(i, "NOME", "EMAIL", "MOTHERNAME", new Date(), "CPF", "RG", "PASSWORD",
					"PHONE", Boolean.TRUE));
		}
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(listCustomer);

		return json;

//		return CustomerConverter.toListResource(customerRepository.findAll());
	}

	public void delete(CustomerResource resource) {
		customerRepository.delete(CustomerConverter.toEntity(resource));
	}

	public String findById(Long id) {
		Optional<Customer> c = customerRepository.findById(id);
		if (c.isPresent()) {
			if (StringUtils.isEmpty(c.get().getName())) {
				return "F";
			} else {
				return "J";
			}
		}
		return null;
	}

	@JmsListener(destination = "queue.sample")
	public void onReceiverQueue(String str) {
		System.out.println(str);
	}

	@JmsListener(destination = "topic.sample", containerFactory = "jmsFactoryTopic")
	public void onReceiverTopic(String str) {
		System.out.println(str);
	}
	
}
