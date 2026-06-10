/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rajaayam.rajaayam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author pian
 */
@Entity
@Table(name = "order_items")
public class OrderItem {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "menu_id")
    private Long menuId;

    private Integer qty;

    private Integer harga;

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Long getId() {
        return id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public Integer getQty() {
        return qty;
    }

    public Integer getHarga() {
        return harga;
    }
}
