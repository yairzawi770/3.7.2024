package full.postgresql.demo;

import full.postgresql.demo.model.Customer;
import full.postgresql.demo.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class DemoApplication {
 private static Optional<Customer>  getCustomer(Integer i) {
	 if(i > 0 )
		 return Optional.of(new Customer());
	 else
		 return Optional.empty();
 }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Person person = new Person();
		person.setName("Yair");

		System.out.println(person.getName());
		Optional<Customer> c = getCustomer(1);
		if(c.isPresent()) {
			c.get().setEmail("hello.@gmail.com");
			System.out.println(c.get().getEmail());
		}




	}
}



