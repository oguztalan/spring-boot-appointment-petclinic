package com.oguztalan.petclinic.controller;

import com.oguztalan.petclinic.model.OwnerEntity;
import com.oguztalan.petclinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @RequestMapping
    public String getAllOwners(Model model){
        List<OwnerEntity> list = ownerService.getAllOwners();

        model.addAttribute("owners", list);
        return "list-owners";
    }

}
