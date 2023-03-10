package com.github.parasmani300.rmsinventory.services.impl;

import com.github.parasmani300.rmsinventory.model.StoreItem;
import com.github.parasmani300.rmsinventory.model.WarehouseItem;

import java.util.List;

public interface WarehouseServices {
    public WarehouseItem addWhItem(WarehouseItem whItem);
    public WarehouseItem viewWhItem(Integer whItemId);
    public List<WarehouseItem> viewWhItemByWhIdAndItemId(Integer whId, Integer itemId);
    public WarehouseItem deleteWhItem(Integer whItemId);
    public WarehouseItem updateWhItem(Integer whItemId,String columnName,String columnValue);
    public List<WarehouseItem> viewAllWhItem(Integer pageNo,Integer pageSize);
}
