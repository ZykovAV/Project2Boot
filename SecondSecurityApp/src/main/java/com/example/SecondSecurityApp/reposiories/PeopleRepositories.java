package com.example.SecondSecurityApp.reposiories;

import com.example.SecondSecurityApp.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeopleRepositories extends JpaRepository<Person, Integer> {
    Optional<Person> findByUsername(String username);


}
