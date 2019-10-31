package projetoGenerico.step;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import projetoGenerico.entity.Customer;

@Component("CustomerProcess")
public class CustomerProcess implements ItemProcessor<Iterable<Customer>, Iterable<Customer>> {

	private static Logger LOG = Logger.getLogger(CustomerProcess.class);
	
	@Override
	public Iterable<Customer> process(Iterable<Customer> items) throws Exception {
		items.forEach(c -> {
			c.setActive(Boolean.FALSE);
		});
		LOG.info("CustomerProcess >> WRITER");
		return items;
	}

}
