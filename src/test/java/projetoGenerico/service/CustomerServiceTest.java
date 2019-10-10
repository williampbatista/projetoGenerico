package projetoGenerico.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import projetoGenerico.entity.Customer;
import projetoGenerico.repository.CustomerRepository;

public class CustomerServiceTest {
	Optional<Customer> optionalCustomer;
	@Mock
	CustomerRepository repository;

	@InjectMocks
	CustomerService customerService;

	@Test
	public void testFindByIdPessoaJ() {
		optionalCustomer = Optional.of(new Customer(1l, "PRIMO"));
		when(repository.findById(any(Long.class))).thenReturn(optionalCustomer);
		String tipo = customerService.findById(1l);
		assertEquals("J", tipo);
	}

	@Test
	public void testFindByIdPessoaF() {
		optionalCustomer = Optional.of(new Customer(1l, null));
		when(repository.findById(any(Long.class))).thenReturn(optionalCustomer);
		String tipo = customerService.findById(1l);
		assertEquals("F", tipo);
	}

	@Test
	public void testFindByIdPessoaNull() {
		optionalCustomer = Optional.ofNullable(null);
		when(repository.findById(any(Long.class))).thenReturn(optionalCustomer);
		String tipo = customerService.findById(1l);
		assertEquals(null, tipo);
	}

}
