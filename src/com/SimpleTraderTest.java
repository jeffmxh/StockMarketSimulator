/**
 * 
 */
package com;

/**
 * @author Jeffmxh
 * @Date 2019-05-05 18:19:17
 * @Description 
 *
 */
public class SimpleTraderTest {
    public static void main(String[] args) {
        SimpleTrader t1 = new SimpleTrader(0, 20000, 5, 0.9);
        t1.showStatus();
        System.out.println("---------------------");
        
        double[] stockPrice = {10, 20, 30, 40, 50};
//        boolean tradingStatus;
        for(int i = 0; i < 100; i++) {
            Order order1 = t1.genOrder(stockPrice);
            stockPrice[order1.getStockCode()] = order1.getStockPrice();
            boolean tradingStatus = t1.tradeOrder(order1);
            System.out.println(tradingStatus);
        }
        
//        Order order1 = t1.genOrder(stockPrice);
//        order1.show();
//        System.out.println("---------------------");
//        
//        boolean tradingStatus = t1.tradeOrder(order1);
//        System.out.println(tradingStatus);
//        System.out.println("---------------------");
        for(double stock : stockPrice) {
            System.out.print(stock + "  ");
        }
        System.out.print("\n");
        t1.showStatus();
    }
}
