/**
 * 
 */
package com;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jeffmxh
 * @Date 2019-05-05 10:29:31
 * @Description 
 *
 */
public class OrderTest {
    public static void main(String[] args) {
        Order order1 = new Order(0, 0, 10, 10);
        order1.show();
//        System.out.println(order1.getStockCode());
        List<Order> orderList = new ArrayList<Order>(5);
        orderList.add(new Order(0, 0, 10, 10));
        orderList.add(new Order(1, 0, 10, 15));
        orderList.add(new Order(2, 0, 10, 5));
        orderList.add(new Order(3, 0, 10, 3));
        
        for (Order order : orderList) {
            order.show();
        }
        System.out.println();
        
        Collections.sort(orderList);
        for (Order order : orderList) {
            order.show();
        }
        System.out.println();
        
        Collections.sort(orderList, Collections.reverseOrder());
        for (Order order : orderList) {
            order.show();
        }
        System.out.println("------------------------");
        Map<Integer, List<Order>> orderMap = new HashMap<Integer, List<Order>>();
        orderMap.put(0, new ArrayList<Order>());
        orderMap.get(0).add(new Order(0, 0, 10, 10));
        orderMap.get(0).add(new Order(1, 0, 10, 10));
        orderMap.get(0).get(0).show();
//        System.out.println(orderMap.get(0).size());
    }
}
