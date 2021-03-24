package com.colval.demothymeleaf.Controllers;

import com.colval.demothymeleaf.Controllers.viewmodels.SearchNameViewModel;
import com.colval.demothymeleaf.model.DTO.CustomerDTO;
import com.colval.demothymeleaf.model.entities.Address;
import com.colval.demothymeleaf.model.entities.Customer;
import com.colval.demothymeleaf.model.entities.Store;
import com.colval.demothymeleaf.services.implementation.AddressService;
import com.colval.demothymeleaf.services.implementation.CustomerService;
import com.colval.demothymeleaf.services.implementation.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private String varSearch;
    private final CustomerService customerService;
    private final AddressService addressService;
    private final StoreService storeService;


    public CustomerController(CustomerService customerService, AddressService addressService, StoreService storeService) {
        this.customerService = customerService;
        this.addressService = addressService;
        this.storeService = storeService;
    }

    @GetMapping
    public String customer(Model model) {
//        model.addAttribute("allCustomer", customerService.readAll().stream().limit(15).collect(Collectors.toList()));
//        model.addAttribute("customerCount", customerService.readAll().size());
//        model.addAttribute("searchNames", new searchNameViewModel());
//        return "customer/customer";
        if (varSearch != null && !varSearch.isEmpty()) {
            List<Customer> customers = customerService.getAllCustomerWithFirstLastNameSubStr(varSearch);
            model.addAttribute("nbCustomer", customers.size());
            model.addAttribute("allCustomer", customers);
            model.addAttribute("searchNames", new SearchNameViewModel(varSearch));
            varSearch = null;
        } else {
            model.addAttribute("allCustomer", customerService.readAll());
            model.addAttribute("nbCustomer", customerService.countAllCustomer());
            model.addAttribute("searchNames", new SearchNameViewModel());
        }
        return "customer/customer";
    }


    @PostMapping("/do_search_name")
    public String getSimilarFirstLastName(Model model, SearchNameViewModel searchNameViewModel) {
        /*System.out.println(searchNameViewModel.getFirstName());
        String nameSubStr = searchNameViewModel.getFirstName();
        List<Customer> customersWithName = customerService.getAllCustomerWithFirstLastNameSubStr(nameSubStr);
        int nbCustomers = customersWithName.size();
        model.addAttribute("searchNames", new SearchNameViewModel());
        model.addAttribute("allCustomer", customersWithName);
        model.addAttribute("nbCustomer", nbCustomers);
        return "customer/customer";*/
        varSearch = searchNameViewModel.getFirstName();
        return "redirect:/customer";

    }

    @GetMapping("/{id}")
    public String getCustomerDetails(Model model, @PathVariable Long id) {

        Optional<Customer> customer = customerService.readOne(id);

        model.addAttribute("customer", customer.get());

        return "customer/details";

    }

    @GetMapping("/new")
    public String showAddForms(Model model) {
        List<Address> addresses = addressService.readAll();
        List<Store> stores = storeService.readAll();
        model.addAttribute("customer", new CustomerDTO());
        model.addAttribute("addresses", addresses);
        model.addAttribute("stores", stores);

        return "customer/add";

        //return "customer/addcustomer";
    }

    @PostMapping("/save") //Implémenter l'action "save"
    public String saveCustomer(@Valid CustomerDTO customerDTO) { //@Valid = valider dans le backend si données reçues = DTO
        Customer customer;
        Optional<Address> address = addressService.readOne(customerDTO.getAddressId()); //récupère l'@ qui existe ou pas
        if (customerDTO.getCustomerId() != null) {//Si customer n'existe pas : get new id
            customer = customerService.readOne(customerDTO.getCustomerId()).orElseThrow(() -> new IllegalArgumentException("Customer Id not found")); // l'exception ne crash pas l'app; elle sert de "confirmation"
            customer.setCustomerId(customerDTO.getCustomerId());
        } else { //sinon put
            //recuperation du premier store
            Store store = storeService.readAll().stream().findFirst().orElse(null);
            customer = new Customer();
            customer.setStoreId(store);
        }
        if (customerDTO.getCreateDate() != null)
            customer.setCreateDate(customerDTO.getCreateDate()); //post new customer
        customer.setActive(customerDTO.isActive());
        customer.setEmail(customerDTO.getEmail());
        customer.setLastName(customerDTO.getLastName());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setAddress(address.orElseThrow(null));

        customerService.create(customer);

        return "redirect:/customer";
    }


    @GetMapping("/delete/{id}")
    public String deleteCustomer(Model model, @PathVariable long id){
        customerService.delete(id);
        System.out.println("Client #" + id + " supprimé");
        return "redirect:/customer";
    }

}
