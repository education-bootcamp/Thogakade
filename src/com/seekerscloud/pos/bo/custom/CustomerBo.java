package com.seekerscloud.pos.bo.custom;

import com.seekerscloud.pos.dto.CustomerDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBo {

    public boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException;
    public boolean updateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException;
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<CustomerDto> searchCustomers(String searchText) throws SQLException, ClassNotFoundException;

}
