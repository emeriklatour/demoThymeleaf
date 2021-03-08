package com.colval.demothymeleaf.Controllers;

import com.colval.demothymeleaf.Controllers.viewmodels.SearchNameViewModel;
import com.colval.demothymeleaf.model.entities.Customer;
import com.colval.demothymeleaf.services.implementation.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/all") //GetMapping source de fichiers == resource/templates
    public String customer(Model model){
        model.addAttribute("searchNames", new SearchNameViewModel());
        model.addAttribute("allCustomer", customerService.readAll().stream().limit(10).collect(Collectors.toList()));
        model.addAttribute("nbCustomer", customerService.countAllCustomer());
        return "customer/customer"; //read as folder/file
    }


    @PostMapping("/do_search_name")
    public String searchCustomerByName(Model model, SearchNameViewModel searchNameViewModel){
        System.out.println(searchNameViewModel.getFirstName());
        String firsNameSubStr = searchNameViewModel.getFirstName();
        List<Customer> customersWithName = customerService.getAllCustomerWithFirstNameSubStr(firsNameSubStr);
        int nbCustomers = customersWithName.size();
        model.addAttribute("searchNames", new SearchNameViewModel());
        model.addAttribute("allCustomer", customersWithName);
        model.addAttribute("nbCustomer", nbCustomers);
        return "customer/customer";
    }

    @GetMapping("/{id}")
    public String getCountry(Model model, @PathVariable Long id){

        Optional<Customer> customer=customerService.readOne(id);

        model.addAttribute("customer",customer.get());

        return "customer/details";

    }


}
