package full.postgresql.demo.repository;

import full.postgresql.demo.model.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
    @Modifying @Transactional @Query(value = "ALTER SEQUENCE customer_seq RESTART WITH 1", nativeQuery = true) void resetAutoIncrement();
}