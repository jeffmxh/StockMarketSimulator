/**
 * 
 */
package com;

/**
 * @author Jeffmxh
 * @Date 2019-05-04 22:23:41
 * @Description 
 *
 */
public class SimpleTrader extends BasicTrader {
    private double probToTrade = 0;
    
    public SimpleTrader(int personId, double initCash, int stockMarketSize, double probToTrade) {
        super(personId, initCash, stockMarketSize);
        this.probToTrade = probToTrade;
    }
    
    public boolean tradeOrder(Order order) {
        int stockCode = order.getStockCode();
        int stockNum = order.getStockNum();
        double stockPrice = order.getStockPrice();
        
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
    
    public void setProbToTrade(double newProbToTrade) {
        probToTrade = newProbToTrade;
    }
    
    public double getProbToTrade() {
        return probToTrade;
    }
    
    public Order genOrder(double[] stockPrice) {
        if (Math.random() < probToTrade) {
            int stockToTrade = RandomTools.nextIndex(stockPrice.length);
            double currentStockPrice = stockPrice[stockToTrade];
            double tradeStockPrice = currentStockPrice * (1 + Math.random()/10);
            
            int lowerBound = -stockHold[stockToTrade];
            int upperBound = (int)(cash / tradeStockPrice);
            int tradeOp = RandomTools.randomInt(lowerBound, upperBound);
            
            Order order = new Order(personId, stockToTrade, tradeOp, tradeStockPrice);
            return order;
        } else {
            Order order = new Order(personId, 0, 0, 0);
            return order;
        }
    }
}
