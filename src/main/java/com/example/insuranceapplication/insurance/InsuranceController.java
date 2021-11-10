package com.example.insuranceapplication.insurance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class InsuranceController {
    @Autowired private InsuranceService service;

    @GetMapping("/home/insurances")
    public String showInsuranceList(Model model){
        List<Insurance> listInsurances = service.listAll();
        model.addAttribute("listInsurances",listInsurances);

        return "insurances";
    }
    @GetMapping("/home/insurances/new")
    public String showNewForm(Model model){
        model.addAttribute("insurance", new Insurance());
        model.addAttribute("pageTitle","Add New Insurance");
        return "insurance_form";
    }
    @PostMapping("/home/insurances/save")
    public String saveInsurance(Insurance insurance, RedirectAttributes ra){
        service.save(insurance);
        ra.addFlashAttribute("message","The Insurance have been saved successfully.");
        return "redirect:/home/insurances";
    }
    @GetMapping("/home/insurances/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            Insurance insurance = service.get(id);
            model.addAttribute("insurance", insurance);
            model.addAttribute("pageTitle","Edit Insurance (ID: " + id + ")");
            return "insurance_form";
        } catch (InsuranceNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/home/insurances";
        }
    }

    @GetMapping("/home/insurances/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes ra){
        try {
            service.delete(id);
            ra.addFlashAttribute("message","The Insurance ID "+ id + " has been deleted.");
        } catch (InsuranceNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
        }
        return "redirect:/home/insurances";
    }

}
