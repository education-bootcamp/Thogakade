package com.seekerscloud.pos.view.tm;

import javafx.scene.control.Button;

public class ItemTm {
    private String code;
    private String description;
    private double unitPrice;
    private int qtyOnHand;
    private Button brn;

    public ItemTm() {
    }

    public ItemTm(String code, String description, double unitPrice, int qtyOnHand, Button brn) {
        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
        this.brn = brn;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public Button getBrn() {
        return brn;
    }

    public void setBrn(Button brn) {
        this.brn = brn;
    }
}
