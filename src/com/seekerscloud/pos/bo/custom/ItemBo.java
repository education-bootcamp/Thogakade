package com.seekerscloud.pos.bo.custom;

import com.seekerscloud.pos.dto.CustomerDto;
import com.seekerscloud.pos.dto.ItemDto;

import java.util.ArrayList;

public interface ItemBo {
    public boolean saveItem(ItemDto dto);
    public boolean updateItem(ItemDto dto);
    public boolean deleteItem(String id);
    public ArrayList<ItemDto> searchItems(String searchText);

}
