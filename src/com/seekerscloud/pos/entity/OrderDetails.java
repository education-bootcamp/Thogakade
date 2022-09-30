package com.seekerscloud.pos.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    @Column(name = "unit_price")
    private double unitPrice;
    private int qty;
    //-------------------------
    @ManyToOne
    @JoinColumn(
            name = "order_code",
            nullable = false,
            updatable = false,
            insertable = false,
            foreignKey = @ForeignKey(
                    name = "fk_order_code"
            )
    )
    private Order order;

    @ManyToOne
    @JoinColumn(
            name = "item_code",
            nullable = false,
            updatable = false,
            insertable = false,
            foreignKey = @ForeignKey(
                    name = "fk_item_code"
            )
    )
    private Item item;
    //-------------------------

    public OrderDetails() {
    }

    public OrderDetails(long id, double unitPrice, int qty) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
