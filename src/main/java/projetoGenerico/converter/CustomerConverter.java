package projetoGenerico.converter;

import java.util.ArrayList;
import java.util.List;

import projetoGenerico.entity.Customer;
import projetoGenerico.resource.CustomerResource;

public class CustomerConverter {

	public static Customer toEntity(final CustomerResource resource) {
		final Customer entity = new Customer();
		entity.setActive(resource.getActive());
		entity.setBirthDate(resource.getBirthDate());
		entity.setCpf(resource.getCpf());
		entity.setEmail(resource.getEmail());
		entity.setId(resource.getId());
		entity.setMotherName(resource.getMotherName());
		entity.setName(resource.getName());
		entity.setPassword(resource.getPassword());
		entity.setPhone(resource.getPhone());
		entity.setRg(resource.getRg());
		return entity;
	}

	public static CustomerResource toResource(final Customer entity) {
		final CustomerResource resource = new CustomerResource();
		resource.setActive(entity.getActive());
		resource.setBirthDate(entity.getBirthDate());
		resource.setCpf(entity.getCpf());
		resource.setEmail(entity.getEmail());
		resource.setId(entity.getId());
		resource.setMotherName(entity.getMotherName());
		resource.setName(entity.getName());
		resource.setPassword(entity.getPassword());
		resource.setPhone(entity.getPhone());
		resource.setRg(entity.getRg());
		return resource;
	}
	
	public static List<CustomerResource> toListResource(final Iterable<Customer> iterable) {
		final List<CustomerResource> resources = new ArrayList<CustomerResource>();
		for (final Customer customer : iterable) {
			resources.add(toResource(customer));
		}
		return resources;
	}
	
	

}
