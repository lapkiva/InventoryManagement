package com.project.inventory.util;

import com.project.inventory.bean.InventoryBean;

import java.util.Map;

public class Util {

    /**
     * This method takes each command with the data from the user input and converts it into the InventoryBean
     * @param inputArr - takes input of the entire row of each command
     * @return InventoryBean - if command is report or invalid then it will return null
     */
    public InventoryBean convertToMap(String[] inputArr) {
       InventoryBean bean = new InventoryBean();
       if (ApplicationConstants.CREATE.equalsIgnoreCase(inputArr[0])) {
            bean.setName(inputArr[1]);
            bean.setBuyPrice(Double.parseDouble(inputArr[2]));
            bean.setSellPrice(Double.parseDouble(inputArr[3]));
       } else if (ApplicationConstants.UPDATE_BUY.equalsIgnoreCase(inputArr[0])) {
           bean.setName(inputArr[1]);
           bean.setBuyQuantity(Integer.parseInt(inputArr[2]));
       } else if (ApplicationConstants.UPDATE_SELL.equalsIgnoreCase(inputArr[0])) {
           bean.setName(inputArr[1]);
           bean.setSellQuantity(Integer.parseInt(inputArr[2]));
       } else if (ApplicationConstants.DELETE.equalsIgnoreCase(inputArr[0])) {
           bean.setName(inputArr[1]);
           bean.setDeleted(true);
       } else {
           bean = null;
       }

       return bean;
    }
}
