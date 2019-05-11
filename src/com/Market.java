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
    private List<SimpleTrader> traderList = new ArrayList<>(10);
    
    public Market(double[] stockPrice) {
        this.stockPrice = stockPrice;
        this.stockNum = stockPrice.length;
    }
    
    public void addTrader(double initCash, double probToTrade) {
        SimpleTrader trader = new SimpleTrader(traderNum, initCash, stockNum, probToTrade);
        traderNum++;
        traderList.add(trader);
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
        for(double stock : stockPrice) {
            System.out.print(stock + " ");
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
