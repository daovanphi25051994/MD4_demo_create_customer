package controllers;

import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.CustomerService;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class HomeController {
    @GetMapping("/customers")
    public ModelAndView getCustomers(@ModelAttribute Customer customer) {
        ModelAndView modelAndView = new ModelAndView("customers");
        CustomerService customerService = new CustomerService();
        boolean isSaved = customerService.saveCustomer(customer);
        if (isSaved) {
            ArrayList<Customer> customers = customerService.getCustomerList();
            modelAndView.addObject("customers", customers);
        } else {
            ArrayList<Customer> customers = customerService.getCustomerList();
            modelAndView.addObject("customers", customers);
        }
        return modelAndView;
    }

    @PostMapping("/customers")
    public ModelAndView addCustomer(@ModelAttribute Customer customer) {
        ModelAndView modelAndView = new ModelAndView("customers");
        CustomerService customerService = new CustomerService();
        boolean isSaved = customerService.saveCustomer(customer);
        if (isSaved) {
            ArrayList<Customer> customers = customerService.getCustomerList();
            modelAndView.addObject("customers", customers);
            modelAndView.addObject("message", "save successfully");
        } else {
            ArrayList<Customer> customers = customerService.getCustomerList();
            modelAndView.addObject("customers", customers);
            modelAndView.addObject("message", "save not successfully ");
        }
        return modelAndView;
    }
}
