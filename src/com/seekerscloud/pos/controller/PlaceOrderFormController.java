package com.seekerscloud.pos.controller;

import com.seekerscloud.pos.db.Database;
import com.seekerscloud.pos.modal.Customer;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PlaceOrderFormController {
    public TextField txtDate;
    public ComboBox<String> cmbCustomerIds;

    public void initialize(){
        setDateAndOrderId();
        loadAllCustomerIds();
    }

    private void loadAllCustomerIds() {
        for(Customer c: Database.customerTable){
            cmbCustomerIds.getItems().add(c.getId());
        }
    }

    private void setDateAndOrderId() {
        // set Date
        /*Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String d =df.format(date);
        txtDate.setText(d);*/
        txtDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }

}
