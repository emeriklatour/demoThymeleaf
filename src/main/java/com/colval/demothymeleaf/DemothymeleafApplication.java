package com.colval.demothymeleaf;

import com.colval.demothymeleaf.model.entities.Customer;
import com.colval.demothymeleaf.services.implementation.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemothymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemothymeleafApplication.class, args);
    }


}
