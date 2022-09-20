package com.seekerscloud.pos.bo.custom;

import com.seekerscloud.pos.dto.CustomerDto;

import java.util.ArrayList;

public interface CustomerBo {

    public boolean saveCustomer(CustomerDto dto);
    public boolean updateCustomer(CustomerDto dto);
    public boolean deleteCustomer(String id);
    public ArrayList<CustomerDto> searchCustomers(String searchText);

}
