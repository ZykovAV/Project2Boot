package com.example.demo.controller;

import com.example.demo.models.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showUsers(Model model) {
        model.addAttribute("users_list", userService.getListUser());
        return "pages/users";
    }

    @GetMapping("/new")
    public String addUser(@ModelAttribute("user") User user) {
        return "pages/add_user";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "pages/edit_user";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "pages/delete_user";
    }

//    @PostMapping()
//    public String add(@ModelAttribute("user") @Valid User user,
//                      BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "pages/add_user";
//        }
//        userService.addUser(user);
//        return "redirect:/";
//    }
    @PostMapping()
    public String add(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

//    @PatchMapping("/{id}")
//    public String edit(@ModelAttribute("user") @Valid User user,
//                       BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "pages/edit_user";
//        }
//        userService.editUser(user);
//        return "redirect:/";
//    }
    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute("user") User user) {
        userService.deleteUser(user);
        return "redirect:/";
    }
}