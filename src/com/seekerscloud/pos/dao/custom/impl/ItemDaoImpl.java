package com.seekerscloud.pos.dao.custom.impl;

import com.seekerscloud.pos.dao.CrudUtil;
import com.seekerscloud.pos.dao.custom.ItemDao;
import com.seekerscloud.pos.db.DBConnection;
import com.seekerscloud.pos.entity.Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean save(Item i) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Item VALUES (?,?,?,?)",
                i.getCode(),i.getDescription(),i.getUnitPrice(),i.getQtyOnHand());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Item WHERE code=?",s);
    }

    @Override
    public boolean update(Item i) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Item SET description=?,unitPrice=?,qtyOnHand=? WHERE code=?",
                i.getDescription(),i.getUnitPrice(),i.getQtyOnHand(),i.getCode());
    }

    @Override
    public ArrayList<Item> searchItems(String searchText) throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.execute("SELECT * FROM Item WHERE description LIKE ?",searchText);
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
