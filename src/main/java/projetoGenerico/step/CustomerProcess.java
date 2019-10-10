package projetoGenerico.step;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import projetoGenerico.entity.Customer;

@Component("CustomerProcess")
public class CustomerProcess implements ItemProcessor<Iterable<Customer>, Iterable<Customer>> {

	@Override
	public Iterable<Customer> process(Iterable<Customer> items) throws Exception {
		items.forEach(c -> {
			c.setActive(Boolean.FALSE);
		});

		return items;
	}

}
