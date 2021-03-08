package com.colval.demothymeleaf.Controllers;

import com.colval.demothymeleaf.services.implementation.CityService;
import com.colval.demothymeleaf.services.implementation.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/city")
public class CityController {
    CityService cityService;

    public CityController(CustomerService customerService){
        this.cityService = cityService;
    }

    @GetMapping("/all") //GetMapping source de fichiers == resource/templates
    public String customer(Model model){
        model.addAttribute("allCities", cityService.getAllTenRandomCity());
        return "city/city"; //read as folder/file
    }
}
