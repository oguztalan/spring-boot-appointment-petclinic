package com.oguztalan.petclinic.controller;

import com.oguztalan.petclinic.constants.ViewConstants;
import com.oguztalan.petclinic.entities.AppointmentEntity;
import com.oguztalan.petclinic.entities.OwnerEntity;
import com.oguztalan.petclinic.model.Appointment;
import com.oguztalan.petclinic.service.impl.AppointmentServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/date")
public class AppointmentController {

    private static final Log LOG = LogFactory.getLog(AppointmentController.class);

    @Autowired
    AppointmentServiceImpl appointmentService;

    @RequestMapping("/list-appointments")
    public String listAppointments(Model model){
        List<AppointmentEntity> list = appointmentService.listAllAppointment();
        model.addAttribute("allAppointment", list);
        return ViewConstants.LIST_APPOINTMENTS;
    }

    @GetMapping("/new")
    public String storeForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return ViewConstants.NEW_APPOINTMENT;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveOwner(@ModelAttribute("appointment") AppointmentEntity appointment) {
        appointmentService.createOrUpdate(appointment);
        return "redirect:/date/list-appointments";
    }




}
