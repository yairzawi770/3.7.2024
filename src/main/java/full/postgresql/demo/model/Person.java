package full.postgresql.demo.model;

import lombok.Getter;
import lombok.Setter;

public class Person {
//    @Getter
//    @Setter
    private String name;

    public String getName() {
        return "My Name is " + name;
    }

    public void setName(String name) {
        if(name!= null) {
            this.name = name;
        }
    }
}

