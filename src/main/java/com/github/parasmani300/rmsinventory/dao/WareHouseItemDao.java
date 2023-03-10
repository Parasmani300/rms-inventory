package com.github.parasmani300.rmsinventory.dao;

import com.github.parasmani300.rmsinventory.model.WarehouseItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WareHouseItemDao extends JpaRepository<WarehouseItem, Integer> {
    public List<WarehouseItem> findByWhIDAndItemID(Integer whID,Integer itemID);
}
