package com.seekerscloud.pos.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer implements SuperEntity{
    @Id
    @Column(name = "customer_id")
    private String id;
    @Column(name = "name",
            nullable = false
    )
    private String name;
    @Column(name = "address",
            nullable = false
    )
    private String address;
    @Column(name = "salary")
    private double salary;
    //------------------------

    @OneToMany(mappedBy = "customer")
    private List<Order> orders= new ArrayList<>();

    //------------------------

    public Customer() {
    }

    public Customer(String id, String name, String address, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

