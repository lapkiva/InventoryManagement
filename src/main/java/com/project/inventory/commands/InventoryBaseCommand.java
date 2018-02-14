package com.project.inventory.commands;



import com.project.inventory.context.InventoryContext;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;


/**
 *  This is the base command and every commands need to extend this class. This class defines the rule that if the
 *  isRelavant is true then only corresponding command gets executed, otherwise not.
 */
public abstract class InventoryBaseCommand implements Command {

    public boolean execute(Context context) throws Exception {
        if (!(context instanceof InventoryContext)) {
            throw new IllegalArgumentException("Must be InventoryContext");
        }
        InventoryContext ictx = (InventoryContext) context;

        if (isRelevant(ictx)) {
            process(ictx);
            return true;
        }
        // return false to continue chain
        return false;
    }

    public abstract void process(InventoryContext ctx) throws Exception;

    public abstract boolean isRelevant(InventoryContext ctx);

}

