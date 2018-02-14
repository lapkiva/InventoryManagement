package com.project.inventory;

import com.project.inventory.bean.InventoryBean;
import com.project.inventory.commands.InventoryCommandPolicy;
import com.project.inventory.context.InventoryContext;
import com.project.inventory.util.ApplicationConstants;
import com.project.inventory.util.Util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * This is the main class. It first takes the user input and store it into a StringBuilder. Then it parse each
 * input row and executes the corresponding command.
 */
public class InventoryMain {

    public static void main(String[] args) {
        Util util = new Util();
        InventoryCommandPolicy policy = new InventoryCommandPolicy();

        try(InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(in)) {
            InventoryContext context = new InventoryContext();

            String input;
            StringBuilder str = new StringBuilder();
            while (!"#".equals(input = br.readLine())) {
                str.append(input+"\n");
            }

            String[] tempArr = str.toString().split("\n");

            for (String temp : tempArr) {
                if (temp != null && temp.trim() != "") {
                    String[] inputArr = temp.trim().split(" ");
                    context.setCommandType(inputArr[0]);
                    InventoryBean bean = util.convertToMap(inputArr);
                    // If the bean is null and command is not create/updateBuy/updateSell/delete/report then it will show an error message but execution will not be stopped
                    if (bean != null || ApplicationConstants.REPORT.equalsIgnoreCase(inputArr[0])) {
                        context.setBean(bean);
                        policy.process(context);
                    } else {
                        System.out.println("Invalid command " + inputArr[0] + "! Only create, " +
                                "updateBuy, updateSell, delete and report are valid commands.");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
