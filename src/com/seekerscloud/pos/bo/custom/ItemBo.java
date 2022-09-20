package com.seekerscloud.pos.bo.custom;

import com.seekerscloud.pos.dto.CustomerDto;
import com.seekerscloud.pos.dto.ItemDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBo {
    public boolean saveItem(ItemDto dto) throws SQLException, ClassNotFoundException;
    public boolean updateItem(ItemDto dto) throws SQLException, ClassNotFoundException;
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<ItemDto> searchItems(String searchText) throws SQLException, ClassNotFoundException;

}
