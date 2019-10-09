package projetoGenerico.step;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import projetoGenerico.entity.Customer;

@Component("CustomerProcess")
public class CustomerProcess implements ItemProcessor<Customer, Customer> {

	@Override
	public Customer process(Customer item) throws Exception {
		item.setName(item.getName() + " PASSOU NO PROCESS");
		return item;
	}

}
