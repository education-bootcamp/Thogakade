package com.seekerscloud.pos.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_code")
    private String orderId;
    private String date;
    @Column(name = "total_cost")
    private double totalCost;

    @ManyToOne
    @JoinColumn(
            name = "customer_id"
    )
    private Customer customer;

    public Order() {
    }

    public Order(String orderId, String date, double totalCost) {
        this.orderId = orderId;
        this.date = date;
        this.totalCost = totalCost;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
