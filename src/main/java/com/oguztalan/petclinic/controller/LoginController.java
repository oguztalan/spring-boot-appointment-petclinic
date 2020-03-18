package com.oguztalan.petclinic.controller;


import com.oguztalan.petclinic.constants.ViewConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class LoginController {


    @GetMapping("/index")
    public String root() {
        return ViewConstants.INDEX;
    }

    @GetMapping("/login")
    public String login() {
        return ViewConstants.LOGIN;
    }

    @RequestMapping("/list")
    public String listOwner() {
        return ViewConstants.LIST_OWNER;
    }
}
