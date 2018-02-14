package com.project.inventory.commands;

import com.project.inventory.context.InventoryContext;
import com.project.inventory.util.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

/**
 * run mvn test to run this test case thru maven
 */
public class InventoryCommandPolicyTest {

    InventoryContext context = new InventoryContext();
    Util util = new Util();
    InventoryCommandPolicy policy = new InventoryCommandPolicy();
    StringBuilder str = new StringBuilder();

    @Before
    public void setUp() throws Exception {

        str.append("create Book01 10.50 13.79\n");
        str.append("create Food01 1.47 3.98\n");
        str.append("create Tab01 57.00 84.98\n");
        str.append("create Med01 30.63 34.29\n");
        str.append("updateBuy Tab01 100\n");
        str.append("updateSell Tab01 2\n");
        str.append("updateBuy Food01 500\n");
        str.append(" updateBuy Book01 100\n");
        str.append("updateBuy Med01 100\n");
        str.append("updateSell Food01 1\n");
        str.append("updateSell Food01 1\n");
        str.append("updateSell Tab01 2\n");
        str.append("report\n");
        str.append("delete Book01\n");
        str.append("updateSell Tab01 5\n");
        str.append("create Mobile01 10.51 44.56\n");
        str.append("updateBuy Mobile01 250\n");
        str.append(" updateSell Mobile01 4\n");
        str.append("updateSell Food01 5\n");
        str.append("updateSell Med01 10\n");
        str.append("report\n");
    }

    @Test
    public void process() {
        String[] tempArr = str.toString().split("\n");

        for (String temp : tempArr) {
            if (temp != null && temp.trim() != "") {
                String[] inputArr = temp.trim().split(" ");
                context.setCommandType(inputArr[0]);
                context.setBean(util.convertToMap(inputArr));
            }
        }
    }
}