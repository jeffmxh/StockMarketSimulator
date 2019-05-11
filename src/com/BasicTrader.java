/**
 * 
 */
package com;

/**
 * @author Jeffmxh
 * @Date 2019-05-04 21:24:41
 * @Description 
 *
 */
public abstract class BasicTrader {
    /** Define the basic structure of Trader
     * @params double initCash: cash holding of the trader at the beginning
     */
    protected int personId;
    protected double cash;
    protected int[] stockHold;
    
    public BasicTrader(int personId, double initCash, int stockMarketSize) {
        this.personId = personId;
        cash = initCash;
        stockHold = new int[stockMarketSize];
    }
    
    public boolean trade(int stockCode, int stockNum, double stockPrice) {
        double cashFlow = -stockNum * stockPrice;
        boolean stockNumLegal = (stockCode <= stockHold.length) && (stockNum + stockHold[stockCode] >= 0);
        boolean cashFlowLegal = (cash + cashFlow >= 0);
        boolean orderLegal = (stockNum >= 0 && cashFlow <= 0) || (stockNum <= 0 && cashFlow >= 0);
        boolean allLegal = stockNumLegal && cashFlowLegal && orderLegal;
        if (allLegal) {
            cash += cashFlow;
            stockHold[stockCode] += stockNum;
            return true;
        } else {
            return false;
        }
    }
    
    public double getCash() {
        return cash;
    }
    
    public int[] getStockHold() {
        return stockHold;
    }
    
    public void showCash() {
        System.out.println("Cash: " + cash);
    }
    
    public void showStockHold() {
        System.out.print("Stock: ");
        for(int stock : stockHold) {
            System.out.print(stock + " ");
        }
        System.out.print("\n");
    }
    
    public void showStatus() {
        System.out.println("Trader id: " + personId);
        showCash();
        showStockHold();
    }
}
