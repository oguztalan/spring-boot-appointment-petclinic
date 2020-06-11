package com.oguztalan.petclinic.controller;

import com.oguztalan.petclinic.constants.ViewConstants;
import com.oguztalan.petclinic.entities.OwnerEntity;
import com.oguztalan.petclinic.exception.RecordNotFoundException;
import com.oguztalan.petclinic.model.User;
import com.oguztalan.petclinic.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @PostMapping("")
    public String saveUser(@ModelAttribute(name = "user") User user) throws RecordNotFoundException {
        user.setActive(true);
        userService.createUser(user);
        return "redirect:/login";
    }

    @GetMapping("list-users")
    public String listUsers(Model model) {
        List<com.oguztalan.petclinic.entities.User> list = userService.listAllUsers();
        model.addAttribute("allUsers", list);
        return ViewConstants.LIST_USERS;
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editUser(@PathVariable(name = "id") Long id) throws RecordNotFoundException {
        ModelAndView mav = new ModelAndView("edit-veterinary");
        com.oguztalan.petclinic.entities.User users = userService.getUserById(id);
        mav.addObject("editUsers", users);

        return mav;
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteOwnerById(Model model, @PathVariable("id") Long id) throws RecordNotFoundException{

        userService.deleteUserById(id);
        return "redirect:/users/list-users";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String editUser(@ModelAttribute(name = "editUsers") com.oguztalan.petclinic.entities.User user) {
        userService.updateUser(user);
        return "redirect:/users/list-users";
    }
}
