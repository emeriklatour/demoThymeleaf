package com.colval.demothymeleaf.Controllers.viewmodels;

public class SearchNameViewModel {
    private String firstname;

    public SearchNameViewModel(String firstname) {
        this.firstname = firstname;
    }

    public SearchNameViewModel() {
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "SearchNameViewModel{" +
                "name='" + firstname + '\'' +
                '}';
    }

}
