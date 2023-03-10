package com.github.parasmani300.rmsinventory.services;

import com.github.parasmani300.rmsinventory.dao.StoreItemDao;
import com.github.parasmani300.rmsinventory.model.StoreItem;
import com.github.parasmani300.rmsinventory.services.impl.StoreItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StoreItemImpl implements StoreItemServices {

    @Autowired
    StoreItemDao storeItemDao;

    @Override
    public StoreItem addStoreItem(StoreItem storeItem) {
        StoreItem storeItem1 = storeItemDao.save(storeItem);
        return storeItem1;
    }

    @Override
    public StoreItem viewStoreItem(Integer storeItemId) {
        Optional<StoreItem> storeItem = storeItemDao.findById(storeItemId);
        if(!storeItem.isPresent()){
            return null;
        }
        return storeItem.get();
    }

    @Override
    public List<StoreItem> viewStoreItemByStoreIdAndItemId(Integer storeId, Integer itemId) {
        List<StoreItem> storeItems = storeItemDao.findByStoreIdAndItemID(storeId,itemId);
        return storeItems;
    }

    @Override
    public StoreItem deleteStoreItem(Integer storeItemId) {
        Optional<StoreItem> storeItem = storeItemDao.findById(storeItemId);
        if(!storeItem.isPresent()){
            return null;
        }
        storeItemDao.deleteById(storeItemId);
        return storeItem.get();
    }

    @Override
    public StoreItem updateStoreItem(Integer storeItemId, String columnName, String columnValue) {
        Optional<StoreItem> storeItemGet = storeItemDao.findById(storeItemId);
        StoreItem storeItem = storeItemGet.get();
        if(columnName.equals("itemID"))
        {
            storeItem.setItemID(Integer.parseInt(columnValue));
        }else if(columnName.equals("stockOnHand"))
        {
            storeItem.setStockOnHand(Integer.parseInt(columnValue));
        }else if(columnName.equals("nonSellableQty")){
            storeItem.setNonSellableQty(Integer.parseInt(columnValue));
        }else if(columnName.equals("openQty")){
            storeItem.setOpenQty(Integer.parseInt(columnValue));
        }else if(columnName.equals("location")){
            storeItem.setLocation(columnValue);
        }else if(columnName.equals("retailPrice")){
            storeItem.setRetailPrice(Double.parseDouble(columnValue));
        }else if(columnName.equals("costPrice")){
            storeItem.setCostPrice(Double.parseDouble(columnValue));
        }else if(columnName.equals("storeId")){
            storeItem.setStoreId(Integer.parseInt(columnValue));
        }
        storeItemDao.save(storeItem);
        return storeItem;
    }

    @Override
    public List<StoreItem> viewAllStoreItem(Integer pageNo,Integer pageSize) {
        Pageable p = PageRequest.of(pageNo,pageSize);
        Page<StoreItem> storeItemPage = storeItemDao.findAll(p);
        List<StoreItem> allStoreItems = storeItemPage.getContent();
        return allStoreItems;
    }
}
