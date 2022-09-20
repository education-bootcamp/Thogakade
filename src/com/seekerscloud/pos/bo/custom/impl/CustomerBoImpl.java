package com.seekerscloud.pos.bo.custom.impl;

import com.seekerscloud.pos.bo.custom.CustomerBo;
import com.seekerscloud.pos.dao.DaoFactory;
import com.seekerscloud.pos.dao.DaoTypes;
import com.seekerscloud.pos.dao.custom.CustomerDao;
import com.seekerscloud.pos.dto.CustomerDto;
import com.seekerscloud.pos.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBo {

    private CustomerDao dao= DaoFactory.getInstance().getDao(DaoTypes.CUSTOMER);

    @Override
    public boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return dao.save(
                new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary())
        );
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) {
        return false;
    }

    @Override
    public ArrayList<CustomerDto> searchCustomers(String searchText) {
        return null;
    }
}
