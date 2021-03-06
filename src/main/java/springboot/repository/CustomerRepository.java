package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
