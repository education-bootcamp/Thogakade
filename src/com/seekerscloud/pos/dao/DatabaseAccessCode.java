package com.seekerscloud.pos.dao;

import com.seekerscloud.pos.db.DBConnection;
import com.seekerscloud.pos.entity.Customer;
import com.seekerscloud.pos.entity.Item;
import javafx.scene.control.Alert;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseAccessCode {

    // search Customer
    public ArrayList<Customer> searchCustomers(String searchText) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Customer WHERE name LIKE ? || address LIKE ?";
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        statement.setString(1,searchText);
        statement.setString(2,searchText);
        ResultSet set = statement.executeQuery();
        ArrayList<Customer> list = new ArrayList<>();
        while (set.next()){
            list.add(new Customer(set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getDouble(4)));
        }
        return list;
    }

     // Search Item
    public ArrayList<Item> searchItems(String searchText) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Item WHERE description LIKE ?";
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        statement.setString(1,searchText);
        ResultSet set = statement.executeQuery();
        ArrayList<Item> itemList= new ArrayList<>();
        while (set.next()){
            itemList.add(new Item(set.getString(1),
                    set.getString(2),
                    set.getDouble(3),
                    set.getInt(4)));
        }
        return itemList;
    }



}
