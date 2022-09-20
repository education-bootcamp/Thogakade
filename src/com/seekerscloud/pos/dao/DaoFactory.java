package com.seekerscloud.pos.dao;

import com.seekerscloud.pos.dao.custom.impl.CustomerDaoImpl;
import com.seekerscloud.pos.dao.custom.impl.ItemDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory(){}

    public static DaoFactory getInstance(){
        return daoFactory==null?(daoFactory= new DaoFactory()):daoFactory;
    }

    public <T> T getDao(DaoTypes type){
        switch (type){
            case CUSTOMER:
                return (T) new CustomerDaoImpl();
            case ITEM:
                return (T) new ItemDaoImpl();
            default:
                return null;
        }
    }

}
