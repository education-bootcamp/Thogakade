package com.seekerscloud.pos.bo.custom.impl;

import com.seekerscloud.pos.bo.custom.ItemBo;
import com.seekerscloud.pos.dto.ItemDto;

import java.util.ArrayList;

public class ItemBoImpl implements ItemBo {
    @Override
    public boolean saveItem(ItemDto dto) {
        return false;
    }

    @Override
    public boolean updateItem(ItemDto dto) {
        return false;
    }

    @Override
    public boolean deleteItem(String id) {
        return false;
    }

    @Override
    public ArrayList<ItemDto> searchItems(String searchText) {
        return null;
    }
}
