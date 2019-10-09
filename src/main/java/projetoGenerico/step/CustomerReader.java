package projetoGenerico.step;

import org.apache.log4j.Logger;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import projetoGenerico.entity.Customer;

@StepScope
@Component("CustomerReader")
public class CustomerReader implements ItemReader<Customer> {
	private static Logger LOG = Logger.getLogger(CustomerReader.class);

	
	@Override
	public Customer read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		LOG.info("CustomerReader");
		return new Customer(1, "Presida");
	}

}
