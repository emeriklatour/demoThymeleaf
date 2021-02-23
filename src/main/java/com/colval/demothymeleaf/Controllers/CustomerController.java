package com.colval.demothymeleaf.Controllers;

import com.colval.demothymeleaf.services.implementation.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/all") //GetMapping source de fichiers == resource/templates
    public String customer(Model model){
        model.addAttribute("allCustomer", customerService.findAllCustomerIdDescAndLimitTen());
        return "customer/customer"; //read as folder/file
    }

}
