package com.github.parasmani300.rmsinventory.services.impl;

import com.github.parasmani300.rmsinventory.model.StoreItem;

import java.util.List;

public interface StoreItemServices {
    public StoreItem addStoreItem(StoreItem storeItem);
    public StoreItem viewStoreItem(Integer storeItemId);
    public List<StoreItem> viewStoreItemByStoreIdAndItemId(Integer storeId, Integer itemId);
    public StoreItem deleteStoreItem(Integer storeItemId);
    public StoreItem updateStoreItem(Integer storeItemId,String columnName,String columnValue);
    public List<StoreItem> viewAllStoreItem(Integer pageNo,Integer pageSize);
}
