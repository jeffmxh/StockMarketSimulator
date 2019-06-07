/**
 * 
 */
package com;

/**
 * @author Jeffmxh
 * @Date 2019-06-05 23:06:35
 * @Description 
 *
 */
public class MarketTest {
    public static void main(String[] args) {
        double[] stockPrice = {10, 20, 30, 40, 50};
        Market market = new Market(stockPrice);
//        market.showStockPrice();
//        market.showStockHistory();
//        market.showTrader();
        for(int i = 0; i < 100; i++) {
            market.addTrader(70000, 0.9);
        }
//        market.showTrader();
        
        for(int i = 0; i < 5; i++) {
            market.runCallAuction();
        }
        market.showStockHistory();
//        market.showTrader();
    }
}
