package projetoGenerico.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projetoGenerico.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	Iterable<Customer> findByActive(Boolean active);
}
