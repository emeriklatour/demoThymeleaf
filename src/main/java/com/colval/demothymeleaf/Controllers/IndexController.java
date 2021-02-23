package com.colval.demothymeleaf.Controllers;

import com.colval.demothymeleaf.services.implementation.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    CustomerService customerService;

    public IndexController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/") //GetMapping source de fichiers == resource/templates
    public String index(Model model){
        //Compter les customers
        model.addAttribute("nbCustomer", customerService.countAllCustomer());
        return "index/index"; //read as folder/file
    }
}
