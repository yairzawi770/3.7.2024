package full.postgresql.demo.controllers;

import full.postgresql.demo.model.Customer;
import full.postgresql.demo.model.CustomerStatus;
import full.postgresql.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/create")
    public String createTable(){
        customerRepository.deleteAll();
        customerRepository.resetAutoIncrement();
        Customer c1 = new Customer(0, "Jon", "Snow", "jon.snow@got.com", CustomerStatus.REGULAR);
        Customer c2 = new Customer(0, "Daenerys", "Targaryen", "daenerys.targaryen@got.com", CustomerStatus.REGULAR);
        Customer c3 = new Customer(0, "Arya", "Stark", "arya.stark@got.com", CustomerStatus.REGULAR);
        Customer c4 = new Customer(0, "Tyrion", "Lannister", "tyrion.lannister@got.com", CustomerStatus.REGULAR);
        customerRepository.save(c1);
        customerRepository.save(c2);
        customerRepository.save(c3);
        customerRepository.save(c4);
        return "table created";
    }

    @GetMapping()
    public Iterable <Customer> getAll() {
        Iterable<Customer> result = customerRepository.findAll();
        return result;
//        Customer c = new Customer(0, "Dany", "Shovevany", "Dany@gmail.com");
//        customerRepository.save(c);
//        return "finished";
    }

    @GetMapping(value = "/{id}")
    public Optional <Customer> getById(@PathVariable Integer id) {
        Optional<Customer> result = customerRepository.findById(Long.valueOf(id));
        return result;
    }

    @PostMapping()
    public Customer insertCustomer(@RequestBody Customer c) {
      Customer result = customerRepository.save(c);
      return result;
    }

    @PutMapping(value = "/{id}")
    public String updateCustomer(@PathVariable Integer id, @RequestBody Customer c) {
        c.setId(id);
        Customer result = customerRepository.save(c);
        return "updated";
    }

    @PatchMapping(value = "/{id}")
    public String patchCustomer(@PathVariable Integer id, @RequestBody Customer c) {
        Optional<Customer> result = customerRepository.findById(Long.valueOf(id));
        if(result.isPresent()) {
            c.setId(id);
            customerRepository.save(c);
            return "updated";
        }
        else {
            return "not found";
        }
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Integer id){
        customerRepository.deleteById(Long.valueOf(id));
        return "deleted";
    }

    @DeleteMapping()
    public String deleteAll(){
       return "deleted";
    }
}
