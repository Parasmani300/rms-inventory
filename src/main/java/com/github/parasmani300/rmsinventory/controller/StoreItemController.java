package com.github.parasmani300.rmsinventory.controller;

import com.github.parasmani300.rmsinventory.dto.ErrorMessage;
import com.github.parasmani300.rmsinventory.dto.Updater;
import com.github.parasmani300.rmsinventory.model.StoreItem;
import com.github.parasmani300.rmsinventory.services.impl.StoreItemServices;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/storeItem")
public class StoreItemController {

    @Autowired
    StoreItemServices storeItemServices;

    @PostMapping("/add")
    public ResponseEntity<StoreItem> addStoreToItem(@RequestBody StoreItem storeItem)
    {
        StoreItem storeItem1 = storeItemServices.addStoreItem(storeItem);
        return new ResponseEntity<StoreItem>(storeItem, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StoreItem>> getAllStoreItem(
            @RequestParam(value = "pageNo",defaultValue = "1",required = false) Integer pageNo,
            @RequestParam(value = "pageSize",defaultValue = "1",required = false) Integer pageSize
    )
    {
        List<StoreItem> storeItemList = storeItemServices.viewAllStoreItem(pageNo,pageSize);
        return new ResponseEntity<List<StoreItem>>(storeItemList,HttpStatus.OK);
    }

    @GetMapping("/get/{storeItemId}")
    public ResponseEntity<StoreItem> getStoreItemById(@PathVariable Integer storeItemId){
        StoreItem storeItem = storeItemServices.viewStoreItem(storeItemId);
        return new ResponseEntity<StoreItem>(storeItem,HttpStatus.OK);
    }

    @GetMapping("/getByStoreItem/{storeId}/{itemId}")
    public ResponseEntity<List<StoreItem>> getStoreAndItemById(@PathVariable Integer storeId, @PathVariable Integer itemId){
        List<StoreItem> storeItems = storeItemServices.viewStoreItemByStoreIdAndItemId(storeId,itemId);
        return new ResponseEntity<List<StoreItem>>(storeItems,HttpStatus.OK);
    }

    @PutMapping("/update/{storeItemId}")
    public ResponseEntity<StoreItem> updateStoreItem(@PathVariable Integer storeItemId, @RequestBody Updater[] updaterArray)
    {
        StoreItem storeItem = null;
        for(int i = 0;i<updaterArray.length;i++)
        {
            storeItem = storeItemServices.updateStoreItem(storeItemId,updaterArray[i].getKey(),updaterArray[i].getValue());
        }
        return new ResponseEntity<StoreItem>(storeItem,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{storeItemId}")
    public ResponseEntity<?> deleteItemById(@PathVariable Integer storeItemId)
    {
        StoreItem storeItem = storeItemServices.deleteStoreItem(storeItemId);
        if(storeItem == null)
        {
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setMessage("No StoreItem found,cannot delete");
            return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.OK);
        }
        return new ResponseEntity<StoreItem>(storeItem,HttpStatus.OK);
    }

}
