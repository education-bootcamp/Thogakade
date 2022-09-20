package com.seekerscloud.pos.controller;

import com.seekerscloud.pos.db.DBConnection;
import com.seekerscloud.pos.view.tm.ItemDetailsTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ItemDetailsFormController {
    public AnchorPane itemDetailsContext;
    public TableView<ItemDetailsTm> tblItems;
    public TableColumn colCode;
    public TableColumn colUnitPrice;
    public TableColumn colQty;
    public TableColumn colTotal;

    public void initialize(){
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
    }

    public void loadOrderDetails(String id){


        try{
            String sql = "SELECT o.orderId,d.itemCode,d.orderId,d.unitPrice,d.qty" +
                    " FROM `Order` o INNER JOIN `Order Details` d ON o.orderId=d.orderId AND o.orderId=?";
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
            statement.setString(1,id);
            ResultSet set = statement.executeQuery();
            ObservableList<ItemDetailsTm> tmList= FXCollections.observableArrayList();
            while(set.next()){
                double tempUnitPrice=set.getDouble(4);
                int tempQtyOnHand=set.getInt(5);
                double tempTotal=tempQtyOnHand*tempUnitPrice;
                tmList.add(new ItemDetailsTm(
                        set.getString(2),tempUnitPrice,tempQtyOnHand,tempTotal
                ));

            }
            tblItems.setItems(tmList);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) itemDetailsContext.getScene().getWindow();
        stage.setScene(new Scene
                (FXMLLoader.load(getClass().
                        getResource("../view/DashboardForm.fxml"))));
    }
}
