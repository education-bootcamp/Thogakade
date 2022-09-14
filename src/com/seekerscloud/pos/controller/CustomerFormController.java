package com.seekerscloud.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.seekerscloud.pos.db.Database;
import com.seekerscloud.pos.modal.Customer;
import com.seekerscloud.pos.view.tm.CustomerTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Optional;

public class CustomerFormController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSalary;
    public TableView<CustomerTm> tblCustomer;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colSalary;
    public TableColumn colOption;
    public JFXButton btnSaveCustomer;

    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));

        searchCustomers();

        tblCustomer.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
            setData(newValue);
        });

    }
    private void setData(CustomerTm tm){
        txtId.setText(tm.getId());
        txtName.setText(tm.getName());
        txtAddress.setText(tm.getAddress());
        txtSalary.setText(String.valueOf(tm.getSalary()));
    }

    private void searchCustomers() {
        ObservableList<CustomerTm> tmList = FXCollections.observableArrayList();
        for (Customer c : Database.customerTable
        ) {
            Button btn = new Button("Delete");
            CustomerTm tm = new CustomerTm(c.getId(), c.getName(), c.getAddress(), c.getSalary(), btn);
            tmList.add(tm);

            btn.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                        "are you sure whether do you want to delete this customer?",
                        ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.get() == ButtonType.YES) {
                    boolean isDeleted = Database.customerTable.remove(c);
                    if (isDeleted) {
                        searchCustomers();
                        new Alert(Alert.AlertType.INFORMATION, "Customer Deleted!").show();
                    } else {
                        new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                    }
                }
            });

        }
        tblCustomer.setItems(tmList);
    }

    public void saveCustomerOnAction(ActionEvent actionEvent) {
        Customer c1 = new Customer(txtId.getText(),
                txtName.getText(), txtAddress.getText(),
                Double.parseDouble(txtSalary.getText()));

        if(btnSaveCustomer.getText().equalsIgnoreCase("Save Customer")){
            boolean isSaved = Database.customerTable.add(c1);
            if (isSaved) {
                searchCustomers();
                clearFields();
                new Alert(Alert.AlertType.INFORMATION, "Customer Saved!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }
        }else{
            // update
        }
    }

    private void clearFields() {
        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        txtSalary.clear();
    }
}
