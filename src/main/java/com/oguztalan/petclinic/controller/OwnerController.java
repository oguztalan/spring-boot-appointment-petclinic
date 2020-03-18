package com.oguztalan.petclinic.controller;

import com.oguztalan.petclinic.constants.ViewConstants;
import com.oguztalan.petclinic.exception.RecordNotFoundException;
import com.oguztalan.petclinic.entities.OwnerEntity;
import com.oguztalan.petclinic.service.impl.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @RequestMapping("/list")
    public String getAllOwners(Model model){
        List<OwnerEntity> list = ownerService.listAllOwners();
        model.addAttribute("allOwners", list);
        return ViewConstants.LIST_OWNER;
    }

    @RequestMapping("/new")
    public String showNewOwnerPage(Model model) {
        OwnerEntity owner = new OwnerEntity();
        model.addAttribute("createOwner",owner);
        return ViewConstants.NEW_OWNER;
    }



    @RequestMapping(value = "/save", method = RequestMethod.POST)
        public String saveOwner(@ModelAttribute("owner") OwnerEntity owner) {
        ownerService.createOrUpdateOwner(owner);
        return "redirect:/owners/list";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") Long id) throws RecordNotFoundException {
        ModelAndView mav = new ModelAndView("edit-owner");
        OwnerEntity owner = ownerService.getOwnerById(id);
        mav.addObject("owner", owner);

        return mav;
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteOwnerById(Model model, @PathVariable("id") Long id) throws RecordNotFoundException{

        ownerService.deleteOwnerById(id);
        return "redirect:/owners/list";
    }





}
