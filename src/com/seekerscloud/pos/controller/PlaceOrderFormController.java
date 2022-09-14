package com.seekerscloud.pos.controller;

import com.seekerscloud.pos.db.Database;
import com.seekerscloud.pos.modal.Customer;
import com.seekerscloud.pos.modal.Item;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PlaceOrderFormController {
    public TextField txtDate;
    public ComboBox<String> cmbCustomerIds;
    public ComboBox<String> cmbItemCodes;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSalary;
    public TextField txtDescription;
    public TextField txtUnitPrice;
    public TextField txtQtyOnHand;
    public TextField txtQty;
    public TableView tblCart;
    public TableColumn colCode;
    public TableColumn colDescription;
    public TableColumn colUnitPrice;
    public TableColumn colQty;
    public TableColumn colTotal;
    public TableColumn colOption;

    public void initialize(){
        setDateAndOrderId();
        loadAllCustomerIds();
        loadAllItemCodes();

        cmbCustomerIds.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if(newValue!=null){
                        setCustomerDetails();
                    }
        });

        cmbItemCodes.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if(newValue!=null){
                        setItemDetails();
                    }
                });

    }

    private void setItemDetails() {
        for (Item i:Database.itemTable
        ) {
            if (i.getCode().equals(cmbItemCodes.getValue())){
                txtDescription.setText(i.getDescription());
                txtUnitPrice.setText(String.valueOf(i.getUnitPrice()));
                txtQtyOnHand.setText(String.valueOf(i.getQtyOnHand()));
            }
        }
    }

    private void setCustomerDetails() {
        for (Customer c:Database.customerTable
             ) {
            if (c.getId().equals(cmbCustomerIds.getValue())){
                txtName.setText(c.getName());
                txtAddress.setText(c.getAddress());
                txtSalary.setText(String.valueOf(c.getSalary()));
            }
        }
    }

    private void loadAllItemCodes() {
        for(Item i : Database.itemTable){
            cmbItemCodes.getItems().add(i.getCode());
        }
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

    public void addToCartOnAction(ActionEvent actionEvent) {
    }
}
