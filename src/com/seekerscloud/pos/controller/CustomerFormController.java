package com.seekerscloud.pos.controller;

import com.seekerscloud.pos.db.Database;
import com.seekerscloud.pos.modal.Customer;
import com.seekerscloud.pos.view.tm.CustomerTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class CustomerFormController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSalary;

    public void initialize(){
        searchCustomers();
    }
    private void searchCustomers(){
        ObservableList<CustomerTm> tmList = FXCollections.observableArrayList();
        for (Customer c:Database.customerTable
             ) {
            Button btn = new Button("Delete");
            CustomerTm tm = new CustomerTm(c.getId(),c.getName(),c.getAddress(),c.getSalary(), btn);
            tmList.add(tm);
        }
    }

    public void saveCustomerOnAction(ActionEvent actionEvent) {
        Customer c1= new Customer(txtId.getText(),
                txtName.getText(),txtAddress.getText(),
                Double.parseDouble(txtSalary.getText()));

        boolean isSaved = Database.customerTable.add(c1);
        if (isSaved){
            new Alert(Alert.AlertType.INFORMATION, "Customer Saved!").show();
        }else{
            new Alert(Alert.AlertType.WARNING, "Try Again!").show();
        }
    }
}
