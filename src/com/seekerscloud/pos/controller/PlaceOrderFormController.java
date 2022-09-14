package com.seekerscloud.pos.controller;

import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PlaceOrderFormController {
    public TextField txtDate;

    public void initialize(){
        /*Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String d =df.format(date);
        txtDate.setText(d);*/
        txtDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }

}
