package com.project.inventory.commands;

import com.project.inventory.bean.InventoryBean;
import com.project.inventory.context.InventoryContext;
import com.project.inventory.util.ApplicationConstants;


public class CreateInventoryCommand extends InventoryBaseCommand {

    /**
     * This method adds the product in the inventory map
     * @param ctx
     * @throws Exception
     */
    public void process(InventoryContext ctx) throws Exception {
        InventoryBean bean = ctx.getBean();
        ctx.addInventoryMap(bean.getName(), bean);
    }

    /**
     * This method helps to check whether to execute the process function or not
     * @param ctx - InventoryContext
     * @return true if the command type is "create" otherwise false
     */
    public boolean isRelevant(InventoryContext ctx) {
        if (ApplicationConstants.CREATE.equalsIgnoreCase(ctx.getCommandType())) {
            return true;
        }
        return false;
    }
}
