package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
}
