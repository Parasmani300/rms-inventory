package com.github.parasmani300.rmsinventory.model;

import javax.persistence.*;

@Entity
@Table(name = "StoreItem")
public class StoreItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer storeitemID;

    Integer storeId;
    Integer itemID;
    Integer stockOnHand;
    Integer nonSellableQty;
    Integer openQty;
    String location;
    Double retailPrice;
    Double costPrice;

    public StoreItem() {
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getStoreitemID() {
        return storeitemID;
    }

    public void setStoreitemID(Integer storeitemID) {
        this.storeitemID = storeitemID;
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
