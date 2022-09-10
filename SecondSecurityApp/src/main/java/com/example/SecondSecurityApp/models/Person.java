package com.example.SecondSecurityApp.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Imya ne doljno bit pustim!")
    @Size(min=2, max=100, message = "Imya doljno soderjat ot 2 do 100 simvolov")
    @Column(name = "username")
    private String username;

    @Min(value = 1900, message = "God rojdeniya ot 1900!")
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @Column(name = "password")
    private String password;

    public Person(int id, String username, int yearOfBirth, String password) {

        this.username = username;
        this.yearOfBirth = yearOfBirth;

    }

    public Person() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int year_of_birth) {
        this.yearOfBirth = year_of_birth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", password='" + password + '\'' +
                '}';
    }
}
