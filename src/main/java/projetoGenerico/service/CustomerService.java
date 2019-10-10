package projetoGenerico.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import projetoGenerico.entity.Customer;
import projetoGenerico.repository.CustomerRepository;
import projetoGenerico.resource.CustomerResource;

@Component
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public void save(CustomerResource customerResource) {
		customerRepository.save(new Customer());
	}

	public Iterable<Customer> findAll() {
		return customerRepository.findAll();
	}

	public void delete(CustomerResource customerResource) {
		customerRepository.delete(new Customer());
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
}
