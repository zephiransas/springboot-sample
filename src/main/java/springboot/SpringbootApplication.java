package springboot;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springboot.domain.Customer;
import springboot.repository.CustomerRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner {

    @Autowired
    CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
    }
}
