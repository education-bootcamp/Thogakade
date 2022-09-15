package com.seekerscloud.pos.view.tm;

public class ItemDetailsTm {
    private String code;
    private double unitPrice;
    private int qty;
    private double total;

    public ItemDetailsTm() {
    }

    public ItemDetailsTm(String code, double unitPrice, int qty, double total) {
        this.code = code;
        this.unitPrice = unitPrice;
        this.qty = qty;
        this.total = total;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
