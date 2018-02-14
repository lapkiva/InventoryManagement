package com.project.inventory.commands;

import com.project.inventory.context.InventoryContext;
import org.apache.commons.chain.impl.ChainBase;

/**
 *  This class chains the commands in one place. Only one command will be executed at a time based on the condition
 *  mentioned in isRelavant method.
 */
public class InventoryCommandPolicy extends ChainBase {

    public InventoryCommandPolicy() {
        addCommand(new CreateInventoryCommand());
        addCommand(new UpdateBuyInventoryCommand());
        addCommand(new UpdateSellInventoryCommand());
        addCommand(new DeleteInventoryCommand());
        addCommand(new ReportCommand());
    }

    public void process(InventoryContext context)  {

       try {
            execute(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
