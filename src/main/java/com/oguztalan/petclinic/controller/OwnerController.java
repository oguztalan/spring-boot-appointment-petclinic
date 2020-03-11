package com.oguztalan.petclinic.controller;

import com.oguztalan.petclinic.exception.RecordNotFoundException;
import com.oguztalan.petclinic.model.OwnerEntity;
import com.oguztalan.petclinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @RequestMapping
    public String getAllOwners(Model model){
        List<OwnerEntity> list = ownerService.getAllOwners();

        model.addAttribute("owners", list);
        return "list-owners";
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editOwnerById(Model model, @PathVariable("id")Optional<Long> id) throws RecordNotFoundException {

        if (id.isPresent()){
            OwnerEntity entity = ownerService.getOwnerById(id.get());
            model.addAttribute("ownersModel",entity);
        }
        else {
            model.addAttribute("ownersModel", new OwnerEntity());
        }
        return "add-edit-owner";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteOwnerById(Model model, @PathVariable("id") Long id) throws RecordNotFoundException{

        ownerService.deleteOwnerById(id);
        return "redirect:/owners/ownersedit";
    }

    @RequestMapping(path= "/createOwner",method = RequestMethod.POST)
    public String createOrUpdateOwner(OwnerEntity entity){

        ownerService.createOrUpdateOwner(entity);
        return "list-owners";
    }

}
