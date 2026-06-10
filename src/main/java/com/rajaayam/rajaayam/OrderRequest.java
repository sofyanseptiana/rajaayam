package com.rajaayam.rajaayam;

import java.util.List;

public class OrderRequest {

    private String customerName;
    //private List<OrderItemRequest> items;
    private List<OrderItemRequest> items;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public List<OrderItemRequest> getItems() {
        return items;
    }
    
    public void setItems(
            List<OrderItemRequest> items) {
        this.items = items;
    }
}
