package com.project.inventory.context;

import com.project.inventory.bean.InventoryBean;
import org.apache.commons.chain.impl.ContextBase;

import java.util.HashMap;
import java.util.Map;

/**
 * This Context object will be shared among the commands to access the common data
 */
public class InventoryContext extends ContextBase {

    /**
     * Map<Product Name, Inventory Bean> - this is the main map where all the inventory will be stored
     */
    Map<String, InventoryBean> inventoryMap;
    /**
     * This bean will be used to pass along with the command
     */
    InventoryBean bean;
    /**
     * Defines the which command needs to be executed
     */
    String commandType;

    /**
     * This variable keeps track of all the previous profits happening in a single execution
     */
    double lastProfit = 0.0;

    public void addInventoryMap(String key, InventoryBean bean) {
        if (inventoryMap == null) {
            inventoryMap = new HashMap<String, InventoryBean>();
        }
        inventoryMap.put(key, bean);
    }

    public void setInventoryMap(Map<String, InventoryBean> inventoryMap) {
        this.inventoryMap = inventoryMap;
    }

    public Map<String, InventoryBean> getInventoryMap() {
        return this.inventoryMap;
    }

    public String getCommandType() {
        return commandType;
    }

    public void setCommandType(String commandType) {
        this.commandType = commandType;
    }

    public InventoryBean getBean() {
        return bean;
    }

    public void setBean(InventoryBean bean) {
        this.bean = bean;
    }

    public double getLastProfit() {
        return lastProfit;
    }

    public void setLastProfit(double lastProfit) {
        this.lastProfit = lastProfit;
    }
}
