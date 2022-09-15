package com.seekerscloud.pos.controller;

import com.seekerscloud.pos.db.Database;
import com.seekerscloud.pos.modal.ItemDetails;
import com.seekerscloud.pos.modal.Order;
import com.seekerscloud.pos.view.tm.ItemDetailsTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ItemDetailsFormController {
    public AnchorPane itemDetailsContext;
    public TableView<ItemDetailsTm> tblItems;
    public TableColumn colCode;
    public TableColumn colUnitPrice;
    public TableColumn colQty;
    public TableColumn colTotal;

    public void loadOrderDetails(String id){
        for (Order o: Database.orderTable
             ) {
            if (o.getOrderId().equals(id)){
                ObservableList<ItemDetailsTm> tmList= FXCollections.observableArrayList();
                for (ItemDetails d:o.getItemDetails()
                     ) {
                    double tempUnitPrice=d.getUnitPrice();
                    int tempQtyOnHand=d.getQty();
                    double tempTotal=tempQtyOnHand*tempUnitPrice;
                    tmList.add(new ItemDetailsTm(
                            d.getCode(),d.getUnitPrice(),d.getQty(),tempTotal
                    ));
                }
                tblItems.setItems(tmList);
                return;
            }
        }
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) itemDetailsContext.getScene().getWindow();
        stage.setScene(new Scene
                (FXMLLoader.load(getClass().
                        getResource("../view/DashboardForm.fxml"))));
    }
}
