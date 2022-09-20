package com.seekerscloud.pos.controller;

import com.jfoenix.controls.JFXButton;

import com.seekerscloud.pos.bo.BoFactory;
import com.seekerscloud.pos.bo.BoTypes;
import com.seekerscloud.pos.bo.custom.CustomerBo;
import com.seekerscloud.pos.dao.DaoFactory;
import com.seekerscloud.pos.dao.DaoTypes;
import com.seekerscloud.pos.dao.custom.CustomerDao;
import com.seekerscloud.pos.dao.custom.impl.CustomerDaoImpl;
import com.seekerscloud.pos.dto.CustomerDto;
import com.seekerscloud.pos.entity.Customer;
import com.seekerscloud.pos.view.tm.CustomerTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
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
    public AnchorPane customerFormContext;
    public TextField txtSearch;

    private CustomerBo customerBo= BoFactory.getInstance().getBo(BoTypes.CUSTOMER);

    private String searchText="";

    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));

        searchCustomers(searchText);
        tblCustomer.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (null!=newValue){// newValue!=null
                        setData(newValue);
                    }
                });
        txtSearch.textProperty()
                .addListener((observable, oldValue, newValue) -> {
                    searchText=newValue;
                    searchCustomers(searchText);
                });

    }

    private void setData(CustomerTm tm) {
        txtId.setText(tm.getId());
        txtName.setText(tm.getName());
        txtAddress.setText(tm.getAddress());
        txtSalary.setText(String.valueOf(tm.getSalary()));
        btnSaveCustomer.setText("Update Customer");
    }

    private void searchCustomers(String text) {
        String searchText="%"+text+"%";
        try {

            ObservableList<CustomerTm> tmList = FXCollections.observableArrayList();

           ArrayList<CustomerDto> customerList= customerBo.searchCustomers(searchText);

            for (CustomerDto c: customerList){
                    Button btn = new Button("Delete");
                    CustomerTm tm = new CustomerTm(
                            c.getId(),
                            c.getName(),
                            c.getAddress(),
                            c.getSalary(),
                            btn);
                    tmList.add(tm);
                    btn.setOnAction(event -> {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                                "are you sure whether do you want to delete this customer?",
                                ButtonType.YES, ButtonType.NO);
                        Optional<ButtonType> buttonType = alert.showAndWait();
                        if (buttonType.get() == ButtonType.YES) {
                            try {
                                if (customerBo.deleteCustomer(tm.getId())) {
                                    searchCustomers(searchText);
                                    new Alert(Alert.AlertType.INFORMATION, "Customer Deleted!").show();
                                } else {
                                    new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                                }
                            }catch (ClassNotFoundException | SQLException e){
                                e.printStackTrace();
                            }


                        }
                    });
            }
            tblCustomer.setItems(tmList);

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

    }

    public void saveCustomerOnAction(ActionEvent actionEvent) {

        if (btnSaveCustomer.getText().equalsIgnoreCase("Save Customer")) {
            try {
                boolean isCustomerSaved = customerBo.saveCustomer(
                        new CustomerDto(
                                txtId.getText(),
                                txtName.getText(), txtAddress.getText(),
                                Double.parseDouble(txtSalary.getText())
                        )
                );
                if (isCustomerSaved) {
                    searchCustomers(searchText);
                    clearFields();
                    new Alert(Alert.AlertType.INFORMATION, "Customer Saved!").show();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                }

            }catch (ClassNotFoundException | SQLException e){
                e.printStackTrace();
            }

        } else {

            try {

                boolean isCustomerUpdated = customerBo.updateCustomer(
                        new CustomerDto(
                                txtId.getText(),
                                txtName.getText(), txtAddress.getText(),
                                Double.parseDouble(txtSalary.getText())
                        )
                );

                if (isCustomerUpdated) {
                    searchCustomers(searchText);
                    clearFields();
                    new Alert(Alert.AlertType.INFORMATION, "Customer Updated!").show();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                }
            }catch (ClassNotFoundException | SQLException e){
                e.printStackTrace();
            }
        }
    }

    private void clearFields() {
        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        txtSalary.clear();
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
       Stage stage= (Stage)customerFormContext.getScene().getWindow();
       stage.setScene(new Scene
               (FXMLLoader.load(getClass().
                       getResource("../view/DashboardForm.fxml"))));
    }

    public void newCustomerOnAction(ActionEvent actionEvent) {
        btnSaveCustomer.setText("Save Customer");
    }
}
