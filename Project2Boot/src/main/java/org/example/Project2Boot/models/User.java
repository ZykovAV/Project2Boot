package org.example.Project2Boot.models;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstname")
    @NotEmpty(message = "First name should not be empty")
    @Size(min = 1, max = 30, message = "Should be between 1 and 30 characters")
    private String firstName;

    @Column(name = "lastname")
    @NotEmpty(message = "Last name should not be empty")
    @Size(min = 1, max = 30, message = "Should be between 1 and 30 characters")
    private String lastName;

    @Column(name = "age")
    @Range(min = 0, max = 150, message = "Should be between 0 and 150")
    private int age;

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
