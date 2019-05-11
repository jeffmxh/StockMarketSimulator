/**
 * 
 */
package com;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Jeffmxh
 * @Date 2019-05-07 14:36:50
 * @Description 
 *
 */
public class TradingSystem {
    private List<Order> orderList = new ArrayList<Order>(32);
//    private List<Order> dealResult = new ArrayList<Order>(32);
//    private double dealPrice;
    
    public void addOrder(Order o) {
        orderList.add(o);
    }
    
    public void addMultiOrder(List<Order> orders) {
        orderList.addAll(orders);
    }

    public DealResult callAuctionSingle(int stockCode, List<Order> orders) {
        DealResult dealResult = new DealResult(stockCode);
        List<Order> buyList = new ArrayList<Order>();
        List<Order> sellList = new ArrayList<Order>();
        double dealPrice = 0;

        for (Order order : orders) {
            if (order.getStockNum() > 0) {
                buyList.add((Order) order.clone());
            } else if (order.getStockNum() < 0) {
                sellList.add((Order) order.clone());
            }
        }

        if (buyList.size() == 0 || sellList.size() == 0) {
            return dealResult;
        } else {
            Collections.sort(buyList, Collections.reverseOrder());
            Collections.sort(sellList);
            while ((!buyList.isEmpty()) && (!sellList.isEmpty()) && 
                    buyList.get(0).getStockPrice() >= sellList.get(0).getStockPrice()) {
                if (buyList.get(0).getStockNum() + sellList.get(0).getStockNum() > 0) {
                    dealResult.addOrder(sellList.get(0));
                    buyList.get(0).update(sellList.get(0).getStockNum());
                    dealPrice = buyList.get(0).getStockPrice();
                    sellList.remove(0);
                } else if (buyList.get(0).getStockNum() + sellList.get(0).getStockNum() < 0) {
                    dealResult.addOrder(buyList.get(0));
                    sellList.get(0).update(buyList.get(0).getStockNum());
                    dealPrice = sellList.get(0).getStockPrice();
                    buyList.remove(0);
                } else {
                    dealResult.addOrder(buyList.get(0));
                    dealResult.addOrder(sellList.get(0));
                    dealPrice = (buyList.get(0).getStockPrice() + sellList.get(0).getStockPrice()) / 2;
                    buyList.remove(0);
                    sellList.remove(0);
                }
            }
            dealResult.setPrice(dealPrice);
        }
        return dealResult;
    }
    
    public List<Order> callAuction(List<Order> orders) {
        List<Order> dealResult = new ArrayList<Order>();
        Map<Integer, List<Order>> orderDict = new HashMap<Integer, List<Order>>();
        for (Order order : orders) {
            int stockCode = order.getStockCode();
            if (!orderDict.containsKey(stockCode)) {
                orderDict.put(stockCode, new ArrayList<Order>());
            }
            orderDict.get(stockCode).add(order);
        }
        for(Entry<Integer, List<Order>> entry : orderDict.entrySet()) {
            int stockCode = entry.getKey();
            List<Order> stockOrders = entry.getValue();
            DealResult stockDealResult = callAuctionSingle(stockCode, stockOrders);
            dealResult.addAll(stockDealResult.getDealResult());
        }
        return dealResult;
    }
    

    public void clear() {
        orderList.clear();
    }
    
    public void show() {
        for (Order order : orderList) {
            order.show();
        }
    }    
}
