package com.seekerscloud.pos.bo.custom.impl;

import com.seekerscloud.pos.bo.custom.ItemBo;
import com.seekerscloud.pos.dao.DaoFactory;
import com.seekerscloud.pos.dao.DaoTypes;
import com.seekerscloud.pos.dao.custom.ItemDao;
import com.seekerscloud.pos.dto.CustomerDto;
import com.seekerscloud.pos.dto.ItemDto;
import com.seekerscloud.pos.entity.Customer;
import com.seekerscloud.pos.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl implements ItemBo {

    private ItemDao itemDao= DaoFactory.getInstance().getDao(DaoTypes.ITEM);

    @Override
    public boolean saveItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        return itemDao.save(
                new Item(dto.getCode(),dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand())
        );
    }

    @Override
    public boolean updateItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        return itemDao.update(
                new Item(dto.getCode(),dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand())
        );
    }

    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return itemDao.delete(id);
    }

    @Override
    public ArrayList<ItemDto> searchItems(String searchText) throws SQLException, ClassNotFoundException {
        ArrayList<Item> entities= itemDao.searchItems(searchText);
        ArrayList<ItemDto> dtoList= new ArrayList<>();
        for (Item i: entities){
            dtoList.add(new ItemDto(i.getCode(),i.getDescription(),i.getUnitPrice(),i.getQtyOnHand()));
        }
        return dtoList;
    }
}
