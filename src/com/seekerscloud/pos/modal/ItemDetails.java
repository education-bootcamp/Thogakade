package com.seekerscloud.pos.modal;

public class ItemDetails {
    private String code;
    private String unitPrice;
    private int qty;

    public ItemDetails() {
    }

    public ItemDetails(String code, String unitPrice, int qty) {
        this.code = code;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
