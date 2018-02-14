package com.project.inventory.util;

import java.text.DecimalFormat;

/**
 *  Maps the command name with static object so that they can be referred from anywhere in the without any inconsistency
 */
public class ApplicationConstants {

    public static final String CREATE = "create";
    public static final String UPDATE_BUY = "updateBuy";
    public static final String UPDATE_SELL = "updateSell";
    public static final String DELETE = "delete";
    public static final String REPORT = "report";
    public static final DecimalFormat df = new DecimalFormat("#0.00");
}
