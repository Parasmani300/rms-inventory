package com.github.parasmani300.rmsinventory.model;

import javax.persistence.*;

@Entity
@Table(name = "WarehouseItem")
public class WarehouseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer whitemID;
    Integer whID;
    Integer itemID;
    Integer stockOnHand;
    Integer nonSellableQty;
    Integer openQty;
    String location;
    Double retailPrice;
    Double costPrice;


    public WarehouseItem() {
    }

    public Integer getWhitemID() {
        return whitemID;
    }

    public void setWhitemID(Integer whitemID) {
        this.whitemID = whitemID;
    }

    public Integer getWhID() {
        return whID;
    }

    public void setWhID(Integer whID) {
        this.whID = whID;
    }

    public Integer getItemID() {
        return itemID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    public Integer getStockOnHand() {
        return stockOnHand;
    }

    public void setStockOnHand(Integer stockOnHand) {
        this.stockOnHand = stockOnHand;
    }

    public Integer getNonSellableQty() {
        return nonSellableQty;
    }

    public void setNonSellableQty(Integer nonSellableQty) {
        this.nonSellableQty = nonSellableQty;
    }

    public Integer getOpenQty() {
        return openQty;
    }

    public void setOpenQty(Integer openQty) {
        this.openQty = openQty;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }
}
