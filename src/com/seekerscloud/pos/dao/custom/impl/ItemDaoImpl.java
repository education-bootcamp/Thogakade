package com.seekerscloud.pos.dao.custom.impl;

import com.seekerscloud.pos.dao.custom.ItemDao;
import com.seekerscloud.pos.db.DBConnection;
import com.seekerscloud.pos.entity.Item;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean save(Item i) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO Item VALUES (?,?,?,?)";
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        statement.setString(1,i.getCode());
        statement.setString(2,i.getDescription());
        statement.setDouble(3,i.getUnitPrice());
        statement.setInt(4,i.getQtyOnHand());
        return statement.executeUpdate()>0;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql1 = "DELETE FROM Item WHERE code=?";
        PreparedStatement statement1 = DBConnection.getInstance().getConnection().prepareStatement(sql1);
        statement1.setString(1,s);
        return statement1.executeUpdate()>0;
    }

    @Override
    public boolean update(Item i) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Item SET description=?,unitPrice=?,qtyOnHand=? WHERE code=?";
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        statement.setString(1,i.getDescription());
        statement.setDouble(2,i.getUnitPrice());
        statement.setInt(3,i.getQtyOnHand());
        statement.setString(4,i.getCode());
        return statement.executeUpdate()>0;
    }
}
