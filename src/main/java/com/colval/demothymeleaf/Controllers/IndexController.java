package com.colval.demothymeleaf.Controllers;

import com.colval.demothymeleaf.services.implementation.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class IndexController {

    public IndexController(){ }

    @GetMapping("/") //GetMapping source de fichiers == resource/templates
    public String index(Model model){
        //Compter les customers
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String strDate= dtf.format(now);

        model.addAttribute("Greetings", "Hello World Emerik! " + strDate);
        return "index/index"; //read as folder/file
    }
}
