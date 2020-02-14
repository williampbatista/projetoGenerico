package projetoGenerico.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import projetoGenerico.entity.Customer;
import projetoGenerico.repository.CustomerRepository;
import projetoGenerico.resource.CustomerResource;

@RunWith(MockitoJUnitRunner.Silent.class)
public final class CustomerServiceTest {
	
	private static final Logger LOG = Logger.getLogger(CustomerServiceTest.class);

	@InjectMocks
	CustomerService customerService;

	@Mock
	CustomerRepository repository;

	@Test
	public void testFindById() {
		LOG.info("CustomerServiceTest >> testFindById()");
		when(repository.findById(any(Long.class))).thenReturn(Optional.of(new Customer(1l, "Presida")));
		Optional<Customer> customer = customerService.findById(1l);
		assertNotNull(customer);
	}

	@Test
	public void testFindNullById() {
		LOG.info("CustomerServiceTest >> testFindNullById()");
		when(repository.findById(any(Long.class))).thenReturn(null);
		Optional<Customer> customer = customerService.findById(1l);
		assertNull(customer);
	}

	@Test
	public void testSave() {
		LOG.info("CustomerServiceTest >> testSave()");
		when(repository.save(any(Customer.class))).thenReturn(new Customer(1l, "Presida"));
		Customer customer = customerService.save(new CustomerResource());
		assertNotNull(customer);
	}

}
