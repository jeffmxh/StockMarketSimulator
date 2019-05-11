/**
 * 
 */
package com;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Jeffmxh
 * @Date 2019-05-07 15:43:10
 * @Description 
 *
 */
public class DealResult {
    private List<Order> resultList = new ArrayList<Order>();
    private int stockCode;
    private double stockPrice = 0;
    private boolean status = false;
    
    public DealResult(int stockCode) {
        this.stockCode = stockCode;
    }

    public void addOrder(Order o) {
        resultList.add(o);
        status = true;
    }

    public void setPrice(double price) {
        if (resultList.size() > 0) {
            for (Order order : resultList) {
                order.setStockPrice(price);
            }
            stockPrice = price;
        }
    }

    public int getStockCode() {
        return stockCode;
    }

    public double getPrice() {
        return stockPrice;
    }

    public boolean getStatus() {
        return status;
    }

    public List<Order> getDealResult() {
        return resultList;
    }

    public void show() {
        for (Order order : resultList) {
            order.show();
        }
        System.out.println("Final deal price : " + stockPrice);
    }
}
