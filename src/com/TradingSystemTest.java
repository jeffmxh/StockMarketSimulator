/**
 * 
 */
package com;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeffmxh
 * @Date 2019-05-09 15:12:32
 * @Description 
 *
 */
public class TradingSystemTest {
    public static void main(String[] args) {
        TradingSystem system = new TradingSystem();
        system.addOrder(new Order(0, 0, 10, 10));
        
        List<Order> orderList = new ArrayList<Order>();
        orderList.add(new Order(1, 0, 10, 15));
        orderList.add(new Order(2, 0, -20, 10));
        orderList.add(new Order(3, 0, 10, 14));
        orderList.add(new Order(4, 0, 10, 10));
        
        orderList.add(new Order(1, 1, 10, 15));
        orderList.add(new Order(2, 1, -10, 10));
        orderList.add(new Order(3, 1, 10, 14));
        orderList.add(new Order(4, 1, 10, 10));
        
        system.addMultiOrder(orderList);
//        system.show();
        
        System.out.println("------------------------------");
        DealResult firstAttemp = system.callAuctionSingle(0, orderList);
        firstAttemp.show();        
        
        System.out.println("------------------------------");
        List<Order> secondAttemp = system.callAuction(orderList);
        for (Order order : secondAttemp) {
            order.show();
        }
    }
}
