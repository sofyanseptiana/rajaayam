/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rajaayam.rajaayam.controller;

import com.rajaayam.rajaayam.OrderItemRequest;
import com.rajaayam.rajaayam.OrderItemResponse;
import com.rajaayam.rajaayam.entity.Order;
import com.rajaayam.rajaayam.entity.OrderItem;
import com.rajaayam.rajaayam.repository.OrderItemRepository;
import com.rajaayam.rajaayam.repository.OrderRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rajaayam.rajaayam.OrderRequest;
import com.rajaayam.rajaayam.entity.Menu;
import com.rajaayam.rajaayam.repository.MenuRepository;
import java.util.ArrayList;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final MenuRepository menuRepository;
    
    

    public OrderController(
        OrderRepository orderRepository,
        OrderItemRepository orderItemRepository,
        MenuRepository menuRepository) {

    this.orderRepository = orderRepository;
    this.orderItemRepository = orderItemRepository;
    this.menuRepository = menuRepository;
}

    @GetMapping("/api/orders")
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/api/orders/test")
    public String testOrder() {

        Order order = new Order();

        order.setCustomerName("Budi");
        order.setTotal(30000);
        order.setStatus("PENDING");
        order.setCreatedAt("2026-06-10");

        orderRepository.save(order);

        OrderItem item1 = new OrderItem();

        item1.setOrderId(order.getId());
        item1.setMenuId(1L);
        item1.setQty(2);
        item1.setHarga(14000);

        orderItemRepository.save(item1);

        return "OK";
    }

    @GetMapping("/api/orders/{id}/items")
public List<OrderItemResponse> getOrderItems(
        @PathVariable Long id) {

    List<OrderItem> items =
            orderItemRepository.findByOrderId(id);

    List<OrderItemResponse> result =
            new ArrayList<>();

    for (OrderItem item : items) {

        Menu menu =
                menuRepository.findById(
                        item.getMenuId())
                        .orElse(null);

        OrderItemResponse response =
                new OrderItemResponse();

        response.setNama(
                menu.getNama());

        response.setQty(
                item.getQty());

        result.add(response);
    }

    return result;
}

    @PostMapping("/api/orders")
    public String createOrder(
            @RequestBody OrderRequest request) {
        Order order = new Order();

        int total = 0;

        for (OrderItemRequest item : request.getItems()) {

            total += item.getHarga()
                    * item.getQty();
        }

        order.setCustomerName(
                request.getCustomerName());
        order.setTotal(total);
        order.setStatus("PENDING");
        orderRepository.save(order);

        for (OrderItemRequest item : request.getItems()) {

            OrderItem orderItem
                    = new OrderItem();

            orderItem.setOrderId(
                    order.getId());

            orderItem.setMenuId(
                    item.getId());

            orderItem.setQty(
                    item.getQty());

            orderItem.setHarga(
                    item.getHarga());

            orderItemRepository.save(
                    orderItem);
        }

        return "pesanan berhasil";
    }

}
