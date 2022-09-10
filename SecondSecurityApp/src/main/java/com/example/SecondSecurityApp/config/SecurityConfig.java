package com.example.SecondSecurityApp.config;

import com.example.SecondSecurityApp.security.authProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final authProviderImpl authProvider;

    @Autowired

    public SecurityConfig(authProviderImpl authProvider) {
        this.authProvider = authProvider;
    }


    //    nastroika autentifikacii
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
//        super.configure(auth);
    }
}
