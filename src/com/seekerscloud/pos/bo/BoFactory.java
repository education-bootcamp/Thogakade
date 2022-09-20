package com.seekerscloud.pos.bo;

import com.seekerscloud.pos.bo.custom.impl.CustomerBoImpl;
import com.seekerscloud.pos.bo.custom.impl.ItemBoImpl;


public class BoFactory {
    private static BoFactory boFactory;
    private BoFactory(){}

    public static BoFactory getInstance(){
        return boFactory==null?boFactory = new BoFactory():boFactory;
    }

    public <T> T getBo(BoTypes type){
        switch (type){
            case CUSTOMER:
                return (T) new CustomerBoImpl();
            case ITEM:
                return (T) new ItemBoImpl();
            default:
                return null;
        }
    }

}
