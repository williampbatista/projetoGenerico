package projetoGenerico.step;

import org.apache.log4j.Logger;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import projetoGenerico.entity.Customer;
import projetoGenerico.repository.CustomerRepository;

@StepScope
@Component("CustomerReader")
public class CustomerReader implements ItemReader<Iterable<Customer>> {
	
	private static Logger LOG = Logger.getLogger(CustomerReader.class);

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Iterable<Customer> read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		LOG.info("CustomerReader >> WRITER");
		return customerRepository.findByActive(Boolean.TRUE);
	}
	
	

}
