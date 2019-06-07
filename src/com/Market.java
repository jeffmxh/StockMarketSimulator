/**
 * 
 */
package com;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeffmxh
 * @Date 2019-05-06 09:19:42
 * @Description 
 *
 */
public class Market {
    private int traderNum = 0;
    private int stockNum;
    private double[] stockPrice;
    private List<SimpleTrader> traderList = new ArrayList<SimpleTrader>(10);
    private TradingSystem system = new TradingSystem();
    private List<ArrayList<Double>> stockHistory = new ArrayList<ArrayList<Double>>();
    
    public Market(double[] stockPrice) {
        this.stockPrice = stockPrice;
        this.stockNum = stockPrice.length;
        for(double price : stockPrice) {
            ArrayList<Double> singleStockHistory = new ArrayList<Double>();
            singleStockHistory.add(price);
            stockHistory.add(singleStockHistory);
        }
    }
    
    public void addTrader(double initCash, double probToTrade) {
        SimpleTrader trader = new SimpleTrader(traderNum, initCash, stockNum, probToTrade);
        traderNum++;
        traderList.add(trader);
    }
    
    public void runCallAuction() {
        List<Order> orderList = new ArrayList<Order>();
        for(SimpleTrader trader : traderList) {
            orderList.add(trader.genOrder(stockPrice));
        }
        for(Order order : orderList) {
            order.show();
        }
        List<Order> successOrders = system.callAuction(orderList);
        for(Order order : successOrders) {
            traderList.get(order.getPersonId()).tradeOrder(order);
            stockPrice[order.getStockCode()] = order.getStockPrice();
        }
        for(int i = 0; i < stockPrice.length; i++) {
            stockHistory.get(i).add(stockPrice[i]);
        }
    }
    
    public void showTrader() {
        System.out.println("------------------------------------");
        System.out.println("Current trader: \n");
        if (traderList.size() > 0) {
            for(SimpleTrader trader : traderList) {
                trader.showStatus();
                System.out.print("\n");
            }
        } else {
            System.out.println("No trader in the market right now!");
        }
        System.out.println("------------------------------------");
    }
    
    public void showStockPrice() {
        System.out.println("Current stock price: ");
        for(int i = 0; i < stockPrice.length; i++) {
            System.out.println("Stock" + i + ": " + stockPrice[i]);
        }
        System.out.print("\n");
    }
    
    public void showStockHistory() {
        System.out.println("Stock History: ");
        for(ArrayList<Double> stock : stockHistory) {
            printArray(stock);
        }
    }
    
    public void printArray(ArrayList<Double> array) {
        for(double x : array) {
            System.out.print(x + " ");
        }
        System.out.print("\n");
    }
    
    public static void main(String[] args) {
        double[] stockPrice = {10, 20, 30, 40, 50};
        Market market = new Market(stockPrice);
        market.showStockPrice();
        market.showTrader();
        
        market.addTrader(20000, 0.8);
        market.addTrader(50000, 0.2);
        market.showTrader();
    }
}
