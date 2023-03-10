package com.github.parasmani300.rmsinventory.controller;

import com.github.parasmani300.rmsinventory.dto.ErrorMessage;
import com.github.parasmani300.rmsinventory.dto.Updater;
import com.github.parasmani300.rmsinventory.model.WarehouseItem;
import com.github.parasmani300.rmsinventory.services.impl.WarehouseServices;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/wh")
@RestController
@CrossOrigin
public class WareHouseController {

    @Autowired
    WarehouseServices warehouseServices;

    @PostMapping("/add")
    public ResponseEntity<WarehouseItem> addItemToStore(@RequestBody WarehouseItem warehouseItem)
    {
        WarehouseItem warehouseItem1 = warehouseServices.addWhItem(warehouseItem);
        return new ResponseEntity<WarehouseItem>(warehouseItem1, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<WarehouseItem>> getAllWareHouseItem(
            @RequestParam(value = "pageNo",defaultValue = "1",required = false) Integer pageNo,
            @RequestParam(value = "pageSize",defaultValue = "1",required = false) Integer pageSize
    )
    {
        List<WarehouseItem> warehouseItems = warehouseServices.viewAllWhItem(pageNo,pageSize);
        return new ResponseEntity<List<WarehouseItem>>(warehouseItems,HttpStatus.OK);
    }

    @GetMapping("/get/{whID}")
    public ResponseEntity<?> getWareHouseItemById(@PathVariable Integer whID)
    {
        WarehouseItem warehouseItem = warehouseServices.viewWhItem(whID);
        if(warehouseItem == null){
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setMessage("No such product ID");
            return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.OK);
        }

        return new ResponseEntity<WarehouseItem>(warehouseItem,HttpStatus.OK);
    }

    @GetMapping("/getByStoreIdAndItemId/{whId}/{itemId}")
    public ResponseEntity<?> getWareHouseByStoreIdAndItemId(@PathVariable Integer whId,@PathVariable Integer itemId)
    {
        List<WarehouseItem> warehouseItems = warehouseServices.viewWhItemByWhIdAndItemId(whId,itemId);
        return new ResponseEntity<List<WarehouseItem>>(warehouseItems,HttpStatus.OK);
    }

    @PutMapping("/update/{whId}")
    public ResponseEntity<?> updateWhItem(@PathVariable Integer whId, @RequestBody Updater[] updaterArray)
    {
        WarehouseItem warehouseItem = null;
        for(int i = 0;i<updaterArray.length;i++)
        {
            System.out.println(updaterArray[i].getKey());
            System.out.println(updaterArray[i].getValue());
            warehouseItem = warehouseServices.updateWhItem(whId,updaterArray[i].getKey(),updaterArray[i].getValue());
        }
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage("Item not found to update");
        return new ResponseEntity<>(warehouseItem==null?errorMessage:warehouseItem,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{whId}")
    public ResponseEntity<?> deleteWhItem(@PathVariable Integer whId)
    {
       WarehouseItem warehouseItem =  warehouseServices.deleteWhItem(whId);
       if(warehouseItem == null)
       {
           System.out.println("Cannot delete, Item not found");
           ErrorMessage errorMessage = new ErrorMessage();
           errorMessage.setMessage("Cannot delete, Item not found");
           return  new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.OK);
       }
       return new ResponseEntity<WarehouseItem>(warehouseItem,HttpStatus.OK);
    }

}
