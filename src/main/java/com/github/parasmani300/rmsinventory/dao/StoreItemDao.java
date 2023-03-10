package com.github.parasmani300.rmsinventory.dao;

import com.github.parasmani300.rmsinventory.model.StoreItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

public interface StoreItemDao extends JpaRepository<StoreItem,Integer> {
     List<StoreItem> findByStoreIdAndItemID(Integer storeId, Integer itemID);
}
