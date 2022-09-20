package com.seekerscloud.pos.dao.custom.impl;

import com.seekerscloud.pos.dao.custom.CustomerDao;
import com.seekerscloud.pos.db.DBConnection;
import com.seekerscloud.pos.entity.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean save(Customer c) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO Customer VALUES (?,?,?,?)";
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        statement.setString(1,c.getId());
        statement.setString(2,c.getName());
        statement.setString(3,c.getAddress());
        statement.setDouble(4,c.getSalary());
        return statement.executeUpdate()>0;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql1 = "DELETE FROM Customer WHERE id=?";
        PreparedStatement statement1 = DBConnection.getInstance().getConnection().prepareStatement(sql1);
        statement1.setString(1,s);
        return statement1.executeUpdate()>0;
    }

    @Override
    public boolean update(Customer c) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Customer SET name=?,address=?,salary=? WHERE id=?";
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        statement.setString(1, c.getName());
        statement.setString(2, c.getAddress());
        statement.setDouble(3, c.getSalary());
        statement.setString(4, c.getId());
        return statement.executeUpdate()>0;
    }

    @Override
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
}
