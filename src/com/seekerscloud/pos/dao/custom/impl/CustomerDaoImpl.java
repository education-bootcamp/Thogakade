package com.seekerscloud.pos.dao.custom.impl;

import com.seekerscloud.pos.dao.custom.CustomerDao;
import com.seekerscloud.pos.db.DBConnection;
import com.seekerscloud.pos.entity.Customer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
