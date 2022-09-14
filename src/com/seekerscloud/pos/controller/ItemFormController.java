package com.seekerscloud.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.seekerscloud.pos.view.tm.ItemTm;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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

    public void backToHomeOnAction(ActionEvent actionEvent) {
    }

    public void newItemOnAction(ActionEvent actionEvent) {
    }
}
