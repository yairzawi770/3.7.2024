package full.postgresql.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Customer {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    @Getter@Setter
    protected String firstName;

//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        if(firstName != null)
//             this.firstName = firstName;
//    }

    @Getter@Setter
    protected String lastName;

    @Getter@Setter
    protected String email;

    @Getter@Setter
    protected CustomerStatus status;

    public Customer() {
    }

    public Customer(Integer id, String firstName, String lastName, String email, CustomerStatus status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
    }

    public Customer(Integer id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = CustomerStatus.REGULAR;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status.name() +
                '}';
    }
}
