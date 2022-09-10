package com.example.SecondSecurityApp.services;

import com.example.SecondSecurityApp.models.Person;
import com.example.SecondSecurityApp.reposiories.PeopleRepositories;
import com.example.SecondSecurityApp.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {

    private final PeopleRepositories peopleRepositories;

    @Autowired
    public PersonDetailsService(PeopleRepositories peopleRepositories) {
        this.peopleRepositories = peopleRepositories;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepositories.findByUsername(username);
        if(person.isEmpty()){
            throw new UsernameNotFoundException("User not found!1");
        }
        return new PersonDetails(person.get());
    }
}
