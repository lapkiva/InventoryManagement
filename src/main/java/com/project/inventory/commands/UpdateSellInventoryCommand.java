package com.project.inventory.commands;

import com.project.inventory.bean.InventoryBean;
import com.project.inventory.context.InventoryContext;
import com.project.inventory.util.ApplicationConstants;

import java.util.Map;

public class UpdateSellInventoryCommand extends InventoryBaseCommand {
    /**
     * This method helps to update the sell quantity in the InventoryMap
     * @param ctx
     * @throws Exception
     */
    public void process(InventoryContext ctx) throws Exception {
        Map<String, InventoryBean> map = ctx.getInventoryMap();
        InventoryBean tempBean = ctx.getBean();
        InventoryBean bean = map.get(tempBean.getName());
        bean.setSellQuantity(bean.getSellQuantity() + tempBean.getSellQuantity());
        map.put(bean.getName(), bean);
        ctx.setInventoryMap(map);
    }

    /**
     * This method helps to check whether to execute the process function or not
     * @param ctx
     * @return true if the command type is "updateSell" otherwise false
     */
    public boolean isRelevant(InventoryContext ctx) {
        if (ApplicationConstants.UPDATE_SELL.equalsIgnoreCase(ctx.getCommandType())) {
            return true;
        }
        return false;
    }
}
