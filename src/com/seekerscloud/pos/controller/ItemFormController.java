package com.seekerscloud.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.seekerscloud.pos.bo.BoFactory;
import com.seekerscloud.pos.bo.BoTypes;
import com.seekerscloud.pos.bo.custom.ItemBo;
import com.seekerscloud.pos.dao.DaoFactory;
import com.seekerscloud.pos.dao.DaoTypes;
import com.seekerscloud.pos.dao.custom.ItemDao;
import com.seekerscloud.pos.dao.custom.impl.ItemDaoImpl;
import com.seekerscloud.pos.dto.ItemDto;
import com.seekerscloud.pos.entity.Item;
import com.seekerscloud.pos.view.tm.ItemTm;
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

public class ItemFormController {
    public AnchorPane itemFormContext;
    public TextField txtCode;
    public TextField txtDescription;
    public TextField txtUnitPrice;
    public TextField txtQtyOnHand;
    public JFXButton btnSaveItem;
    public TextField txtSearch;
    public TableView<ItemTm> tblItem;
    public TableColumn colCode;
    public TableColumn colDescription;
    public TableColumn colUnitPrice;
    public TableColumn colQtyOnHand;
    public TableColumn colOption;

    private ItemBo itemBo= BoFactory.getInstance().getBo(BoTypes.ITEM);


    private String searchText = "";

    public void initialize() {
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));

        searchItems(searchText);
        tblItem.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (null != newValue) {// newValue!=null
                        setData(newValue);
                    }
                });
        txtSearch.textProperty()
                .addListener((observable, oldValue, newValue) -> {
                    searchText = newValue;
                    searchItems(searchText);
                });

    }

    private void setData(ItemTm tm) {
        txtCode.setText(tm.getCode());
        txtDescription.setText(tm.getDescription());
        txtUnitPrice.setText(String.valueOf(tm.getUnitPrice()));
        txtQtyOnHand.setText(String.valueOf(tm.getQtyOnHand()));
        btnSaveItem.setText("Update Item");
    }

    private void searchItems(String text) {
        String searchText="%"+text+"%";
        try {

            ObservableList<ItemTm> tmList = FXCollections.observableArrayList();

            ArrayList<ItemDto> itemList=itemBo.searchItems(searchText);

            for (ItemDto i:itemList){
                Button btn = new Button("Delete");
                ItemTm tm = new ItemTm(
                        i.getCode(),
                        i.getDescription(),
                        i.getUnitPrice(),
                        i.getQtyOnHand(),
                        btn);
                tmList.add(tm);
                btn.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "are you sure whether do you want to delete this Item?",
                            ButtonType.YES, ButtonType.NO);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if (buttonType.get() == ButtonType.YES) {
                        try {
                            if (itemBo.deleteItem(tm.getCode())) {
                                searchItems(searchText);
                                new Alert(Alert.AlertType.INFORMATION, "Item Deleted!").show();
                            } else {
                                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                            }
                        }catch (ClassNotFoundException | SQLException e){
                            e.printStackTrace();
                        }


                    }
                });
            }
            tblItem.setItems(tmList);

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) itemFormContext.getScene().getWindow();
        stage.setScene(new Scene
                (FXMLLoader.load(getClass().
                        getResource("../view/DashboardForm.fxml"))));
    }

    public void newItemOnAction(ActionEvent actionEvent) {
        btnSaveItem.setText("Save Item");
    }

    public void saveItemOnAction(ActionEvent actionEvent) {


        if (btnSaveItem.getText().equalsIgnoreCase("Save Item")) {
            try {

                boolean isItemSaved = itemBo.saveItem(
                        new ItemDto(txtCode.getText(),
                        txtDescription.getText(), Double.parseDouble(txtUnitPrice.getText()),
                        Integer.parseInt(txtQtyOnHand.getText())));
                if (isItemSaved) {
                    searchItems(searchText);
                    clearFields();
                    new Alert(Alert.AlertType.INFORMATION, "Item Saved!").show();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                }

            }catch (ClassNotFoundException | SQLException e){
                e.printStackTrace();
            }
        } else {
            try {

                boolean isItemUpdated = itemBo.updateItem(
                        new ItemDto(txtCode.getText(),
                                txtDescription.getText(), Double.parseDouble(txtUnitPrice.getText()),
                                Integer.parseInt(txtQtyOnHand.getText())));
                if (isItemUpdated) {
                    searchItems(searchText);
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
        txtCode.clear();
        txtDescription.clear();
        txtUnitPrice.clear();
        txtQtyOnHand.clear();
    }
}
