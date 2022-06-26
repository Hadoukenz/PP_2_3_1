package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("usersList", userService.showAllUsers());
        return "index";
    }

    @GetMapping("/add_user")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add-user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditUser(@PathVariable(name = "id") Long id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "edit-user";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

}