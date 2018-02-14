package com.project.inventory.commands;

import com.project.inventory.bean.InventoryBean;
import com.project.inventory.context.InventoryContext;
import com.project.inventory.util.ApplicationConstants;

import java.util.Map;

public class UpdateBuyInventoryCommand extends InventoryBaseCommand {
    /**
     * This method helps to update the buy quantity in the InventoryMap
     * @param ctx
     * @throws Exception
     */
    public void process(InventoryContext ctx) throws Exception {
        Map<String, InventoryBean> map = ctx.getInventoryMap();
        InventoryBean tempBean = ctx.getBean();
        InventoryBean bean = map.get(tempBean.getName());
        bean.setBuyQuantity(bean.getBuyQuantity() + tempBean.getBuyQuantity());
        map.put(bean.getName(), bean);
        ctx.setInventoryMap(map);
    }

    /**
     * This method helps to check whether to execute the process function or not
     * @param ctx
     * @return true if the command type is "updateBuy" otherwise false
     */
    public boolean isRelevant(InventoryContext ctx) {
        if (ApplicationConstants.UPDATE_BUY.equalsIgnoreCase(ctx.getCommandType())) {
            return true;
        }
        return false;
    }
}
