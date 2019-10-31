package projetoGenerico.step;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import projetoGenerico.entity.Customer;
import projetoGenerico.repository.CustomerRepository;

@Component("CustomerWriter")
public class CustomerWriter implements ItemWriter<Iterable<Customer>> {
	private static Logger LOG = Logger.getLogger(CustomerWriter.class);

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void write(List<? extends Iterable<Customer>> items) throws Exception {
		items.forEach(listCustomer -> {
			customerRepository.saveAll(listCustomer);
		});

		LOG.info("CustomerWriter >> WRITER");
	}

}
