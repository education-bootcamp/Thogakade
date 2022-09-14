package com.seekerscloud.pos.db;

import com.seekerscloud.pos.modal.Customer;
import com.seekerscloud.pos.modal.Item;
import com.seekerscloud.pos.modal.Order;

import java.util.ArrayList;


public class Database {
    public static ArrayList<Customer> customerTable
            = new ArrayList<Customer>();
    public static ArrayList<Item> itemTable
            = new ArrayList<Item>();
    public static ArrayList<Order> orderTable
            = new ArrayList<>();

    static {
        customerTable.add(new Customer("C001","Bandara","Colombo",25000));
        customerTable.add(new Customer("C002","Jayantha","Kalutara",43000));
        customerTable.add(new Customer("C003","Saman","Panadura",23999));
        customerTable.add(new Customer("C004","Kamal","Galle",435666));
        customerTable.add(new Customer("C005","Namal","Matara",239883));

        itemTable.add(new Item("I-001","Description 1",25,20));
        itemTable.add(new Item("I-002","Description 2",34,30));
        itemTable.add(new Item("I-003","Description 3",20,28));
        itemTable.add(new Item("I-004","Description 4",10,40));
        itemTable.add(new Item("I-005","Description 5",50,200));
    }
}
