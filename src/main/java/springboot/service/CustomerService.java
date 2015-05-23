package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.domain.Customer;
import springboot.domain.User;
import springboot.repository.CustomerRepository;

import java.util.List;


@Service
@Transactional
public class CustomerService {

	@Autowired
	CustomerRepository repository;

	public List<Customer> findAll() {
		return repository.findAll();
	}

	public Customer findById(Integer id) {
		return repository.findOne(id);
	}

	public Customer save(Customer customer, User user) {
		customer.setUser(user);
		return repository.save(customer);
	}

}
