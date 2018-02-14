package com.project.inventory.commands;

import com.project.inventory.bean.InventoryBean;
import com.project.inventory.context.InventoryContext;
import com.project.inventory.util.ApplicationConstants;

import java.util.Map;
import java.util.TreeMap;

public class ReportCommand extends InventoryBaseCommand {

    /**
     * This method prints the current inventory details in the specified format sorted by alphabetical order. It also calculates the profit since last report generation
     * @param ctx
     * @throws Exception
     */
    public void process(InventoryContext ctx) throws Exception {
        double profit = 0.0;
        double totalValue = 0.0;

        Map<String, InventoryBean> contextMap = ctx.getInventoryMap();
        Map<String, InventoryBean> treeMap = new TreeMap<>(contextMap);
        System.out.println("INVENTORY REPORT");
        System.out.println("Item Name\t\tBought At\t\tSold At\t\tAvailable Qty\t\tValue");
        System.out.println("---------\t\t---------\t\t-------\t\t-------------\t\t-----");
        for (Map.Entry<String, InventoryBean> entry : treeMap.entrySet()) {
            int availableQty = entry.getValue().getBuyQuantity() - entry.getValue().getSellQuantity();
            // If buy quantity is less than the sell quantity then it will throw an exception
            if (availableQty < 0) {
                throw new RuntimeException("Improper input. Sell Quantity cannot be more that available quantity!");
            }
            if (!entry.getValue().isDeleted()) {
                System.out.println(entry.getKey() + "\t\t\t" + ApplicationConstants.df.format(entry.getValue().getBuyPrice()) + "\t\t\t"
                        + ApplicationConstants.df.format(entry.getValue().getSellPrice()) + "\t\t\t" + availableQty + "\t\t\t"
                        + ApplicationConstants.df.format(availableQty*entry.getValue().getBuyPrice()));
                totalValue += (availableQty*entry.getValue().getBuyPrice());
                profit += (entry.getValue().getSellPrice() - entry.getValue().getBuyPrice()) * entry.getValue().getSellQuantity();

            } else {
                profit -= (availableQty * entry.getValue().getBuyPrice());
            }
        }
        // subtract the previous profit from current profit to display the net profit from the last report generation
        profit -= ctx.getLastProfit();
        System.out.println("Total Value : " + ApplicationConstants.df.format(totalValue));
        System.out.println("Profit since previous report : " + ApplicationConstants.df.format(profit) + "\n\n");
        ctx.setLastProfit(profit);
    }

    /**
     * This method helps to check whether to execute the process function or not
     * @param ctx
     * @return true if the command type is "report" otherwise false
     */
    public boolean isRelevant(InventoryContext ctx) {
        if (ApplicationConstants.REPORT.equalsIgnoreCase(ctx.getCommandType())) {
            return true;
        }
        return false;
    }
}
