package springboot;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Pass {

	@Test
	public void test() {
		System.out.println(new BCryptPasswordEncoder().encode("demo"));
	}

}
