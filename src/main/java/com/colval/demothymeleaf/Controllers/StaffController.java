package com.colval.demothymeleaf.Controllers;

import com.colval.demothymeleaf.Controllers.viewmodels.SearchStoreViewModel;
import com.colval.demothymeleaf.model.entities.Staff;
import com.colval.demothymeleaf.services.IStaffService;
import com.colval.demothymeleaf.services.implementation.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    IStaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/allstaff")
    public String getStaffByStoreID(Model model){
        List<Staff> allStaff = staffService.readAll();
        int nbStaff = allStaff.size();
        model.addAttribute("allStaff", allStaff);
        model.addAttribute("nbStaff", nbStaff);
        model.addAttribute("searchStore", new SearchStoreViewModel());
        return "staff/staff";
    }

    @PostMapping("/do_search_by_store")
    public String searchStaffByStore(Model model, SearchStoreViewModel searchStoreViewModel) {
        Long storeId = searchStoreViewModel.getStoreId();
        List<Staff> staffByStore = staffService.findAllByStore(storeId);
        int nbStaff = staffByStore.size();
        model.addAttribute("searchStore", new SearchStoreViewModel());
        model.addAttribute("allStaff", staffByStore);
        model.addAttribute("nbStaff", nbStaff);
        return "staff/staff";
    }
}
