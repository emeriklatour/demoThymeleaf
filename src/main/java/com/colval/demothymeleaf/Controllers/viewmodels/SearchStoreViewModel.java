package com.colval.demothymeleaf.Controllers.viewmodels;

public class SearchStoreViewModel {
    private Long storeId;

    public SearchStoreViewModel(Long storeId) {
        this.storeId = storeId;
    }

    public SearchStoreViewModel() {
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    @Override
    public String toString() {
        return "SearchStoreViewModel{" +
                "storeId=" + storeId +
                '}';
    }
}
