package com.github.parasmani300.rmsinventory.services;

import com.github.parasmani300.rmsinventory.dao.WareHouseItemDao;
import com.github.parasmani300.rmsinventory.model.StoreItem;
import com.github.parasmani300.rmsinventory.model.WarehouseItem;
import com.github.parasmani300.rmsinventory.services.impl.WarehouseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseItemImpl implements WarehouseServices {

    @Autowired
    WareHouseItemDao wareHouseItemDao;

    @Override
    public WarehouseItem addWhItem(WarehouseItem whItem) {
        WarehouseItem warehouseItem = wareHouseItemDao.save(whItem);
        return warehouseItem;
    }

    @Override
    public WarehouseItem viewWhItem(Integer whItemId) {
        Optional<WarehouseItem> warehouseItemGet = wareHouseItemDao.findById(whItemId);
        if(!warehouseItemGet.isPresent()){
            System.out.println("No such item present");
            return  null;
        }
        WarehouseItem warehouseItem = warehouseItemGet.get();
        return warehouseItem;
    }

    @Override
    public List<WarehouseItem> viewWhItemByWhIdAndItemId(Integer whId, Integer itemId) {
        List<WarehouseItem> warehouseItems = wareHouseItemDao.findByWhIDAndItemID(whId,itemId);
        return warehouseItems;
    }

    @Override
    public WarehouseItem deleteWhItem(Integer whItemId) {
        Optional<WarehouseItem> warehouseItemGet = wareHouseItemDao.findById(whItemId);
        if(!warehouseItemGet.isPresent()){
            return null;
        }
        wareHouseItemDao.deleteById(whItemId);
        return warehouseItemGet.get();
    }

    @Override
    public WarehouseItem updateWhItem(Integer whItemId, String columnName, String columnValue) {
        Optional<WarehouseItem> warehouseItemGet = wareHouseItemDao.findById(whItemId);
        if(!warehouseItemGet.isPresent()){
            System.out.println("Item not found");
            return null;
        }
        WarehouseItem warehouseItem = warehouseItemGet.get();

        if(columnName.equals("itemID"))
        {
            warehouseItem.setItemID(Integer.parseInt(columnValue));
        }else if(columnName.equals("stockOnHand"))
        {
            warehouseItem.setStockOnHand(Integer.parseInt(columnValue));
        }else if(columnName.equals("nonSellableQty")){
            warehouseItem.setNonSellableQty(Integer.parseInt(columnValue));
        }else if(columnName.equals("openQty")){
            warehouseItem.setOpenQty(Integer.parseInt(columnValue));
        }else if(columnName.equals("location")){
            warehouseItem.setLocation(columnValue);
        }else if(columnName.equals("retailPrice")){
            warehouseItem.setRetailPrice(Double.parseDouble(columnValue));
        }else if(columnName.equals("costPrice")){
            warehouseItem.setCostPrice(Double.parseDouble(columnValue));
        }else if(columnName.equals("whID")){
            warehouseItem.setWhID(Integer.parseInt(columnValue));
        }
        wareHouseItemDao.save(warehouseItem);
        return warehouseItem;
    }

    @Override
    public List<WarehouseItem> viewAllWhItem(Integer pageNo, Integer pageSize) {
        Pageable p = PageRequest.of(pageNo,pageSize);
        Page<WarehouseItem> warehouseItemPage = wareHouseItemDao.findAll(p);
        List<WarehouseItem> listWareHouseItem = warehouseItemPage.getContent();
        return listWareHouseItem;
    }
}
