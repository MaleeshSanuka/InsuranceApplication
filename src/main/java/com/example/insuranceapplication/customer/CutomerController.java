package com.example.insuranceapplication.customer;

import com.example.insuranceapplication.insurance.Insurance;
import com.example.insuranceapplication.user.User;
import com.example.insuranceapplication.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CutomerController {
    @Autowired private CustomerService service;

    @GetMapping("/home/customers")
    public String showCustomerList(Model model){
        List<Customer> listCustomers = service.listAll();
        model.addAttribute("listCustomers",listCustomers);

        return ("customers");
    }
    @GetMapping("/home/customers/new")
    public String showNewForm(Model model){
        List<Insurance> listInsurance = service.listInsurance();
        model.addAttribute("listInsuranceNames",listInsurance);
        model.addAttribute("customer", new Customer());
        model.addAttribute("pageTitle","Add New Customer");

        return "customer_form";
    }
    @PostMapping("/home/customers/save")
    public String saveUser(Customer customer, RedirectAttributes ra){
        service.save(customer);
        ra.addFlashAttribute("message","The Customer have been saved successfully.");
        return "redirect:/home/customers";
    }
    @GetMapping("/home/customers/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            List<Insurance> listInsurance = service.listInsurance();
            Customer customer = service.get(id);
            model.addAttribute("customer", customer);
            model.addAttribute("listInsuranceNames",listInsurance);
            model.addAttribute("pageTitle","Edit Customer (ID: " + id + ")");
            return "customer_form";
        } catch (CustomerNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/home/customers";
        }
    }
    @GetMapping("/home/customers/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Integer id, RedirectAttributes ra){
        try {
            service.delete(id);
            ra.addFlashAttribute("message","The customer ID "+ id + " has been deleted.");
        } catch (CustomerNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
        }
        return "redirect:/home/customers";
    }




}
