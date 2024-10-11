package demoqa.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString

public class WebTables {

    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private Integer salary;
    private String department;


    public WebTables(String firstName, String lastName, String email, Integer age, Integer salary, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebTables webTables = (WebTables) o;
        return Objects.equals(firstName, webTables.firstName) && Objects.equals(lastName, webTables.lastName) && Objects.equals(email, webTables.email) && Objects.equals(age, webTables.age) && Objects.equals(salary, webTables.salary) && Objects.equals(department, webTables.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, age, salary, department);
    }
}
