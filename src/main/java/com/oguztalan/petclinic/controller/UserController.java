package com.oguztalan.petclinic.controller;

import com.oguztalan.petclinic.entities.OwnerEntity;
import com.oguztalan.petclinic.model.User;
import com.oguztalan.petclinic.repository.UserRepository;
import com.oguztalan.petclinic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("user",new User());
        return "new-user";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("newUser") com.oguztalan.petclinic.entities.User user) {
        userService.createUser(user);
        return "redirect:/login";
    }
}
