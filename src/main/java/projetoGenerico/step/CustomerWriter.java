package projetoGenerico.step;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import projetoGenerico.entity.Customer;

@SuppressWarnings("rawtypes")
@Component("CustomerWriter")
public class CustomerWriter implements ItemWriter<Customer> {
	private static Logger LOG = Logger.getLogger(CustomerWriter.class);

	@Override
	public void write(List items) throws Exception {
		LOG.info("CustomerWriter >> ai bebeeeeeeeeeee, os caras nao param bebeeee");
	}

}
