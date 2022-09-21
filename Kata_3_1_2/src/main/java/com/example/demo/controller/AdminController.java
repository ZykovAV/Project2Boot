package com.example.demo.controller;


import com.example.demo.models.User;
import com.example.demo.service.UserService;
import com.example.demo.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UserValidator userValidator;

    @Autowired
    public AdminController(UserService userService,
                           PasswordEncoder passwordEncoder, UserValidator userValidator) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.userValidator = userValidator;
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users_list", userService.getListUser());
        return "admin/users";
    }

    @GetMapping("/new")
    public String addUser(@ModelAttribute("user") User user) {
        return "admin/add_user";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "admin/edit_user";
    }

    @GetMapping("/info")
    public String showAdmin(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "admin/info";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "admin/delete_user";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute("user") User user) {

        user.setPassword( passwordEncoder.encode(user.getPassword()) );
        userService.addUser(user);
        return "redirect:/admin/users";
    }

    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("user") @Valid User user,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/edit_user";
        }
        userService.editUser(user);
        return "redirect:/admin/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute("user") User user) {
        userService.deleteUser(user);
        return "redirect:/admin/users";
    }
}