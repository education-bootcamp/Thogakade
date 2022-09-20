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
    // save Customer
    public boolean saveCustomer(Customer c) throws SQLException, ClassNotFoundException {
            String sql="INSERT INTO Customer VALUES (?,?,?,?)";
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
            statement.setString(1,c.getId());
            statement.setString(2,c.getName());
            statement.setString(3,c.getAddress());
            statement.setDouble(4,c.getSalary());
            return statement.executeUpdate()>0;
    }
    // update Customer
    public boolean updateCustomer(Customer c) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Customer SET name=?,address=?,salary=? WHERE id=?";
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        statement.setString(1, c.getName());
        statement.setString(2, c.getAddress());
        statement.setDouble(3, c.getSalary());
        statement.setString(4, c.getId());
        return statement.executeUpdate()>0;
    }
    // delete Customer
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        String sql1 = "DELETE FROM Customer WHERE id=?";
        PreparedStatement statement1 = DBConnection.getInstance().getConnection().prepareStatement(sql1);
        statement1.setString(1,id);
        return statement1.executeUpdate()>0;
    }
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

    //============
    // save Item
    public boolean saveItem(Item i) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO Item VALUES (?,?,?,?)";
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        statement.setString(1,i.getCode());
        statement.setString(2,i.getDescription());
        statement.setDouble(3,i.getUnitPrice());
        statement.setInt(4,i.getQtyOnHand());
        return statement.executeUpdate()>0;
    }
    // Update Item
    public boolean updateItem(Item i) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Item SET description=?,unitPrice=?,qtyOnHand=? WHERE code=?";
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        statement.setString(1,i.getDescription());
        statement.setDouble(2,i.getUnitPrice());
        statement.setInt(3,i.getQtyOnHand());
        statement.setString(4,i.getCode());
        return statement.executeUpdate()>0;
    }
    // delete Item
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        String sql1 = "DELETE FROM Item WHERE code=?";
        PreparedStatement statement1 = DBConnection.getInstance().getConnection().prepareStatement(sql1);
        statement1.setString(1,id);
        return statement1.executeUpdate()>0;
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
