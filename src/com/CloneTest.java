/**
 * 
 */
package com;

/**
 * @author Jeffmxh
 * @Date 2019-05-09 15:03:40
 * @Description 
 *
 */
public class CloneTest {
    public static void main(String[] args) {
        Order a = new Order(0, 0, 10, 10);
        Order b = (Order) a.clone();
        a.show();
        b.show();
        a.setStockPrice(100);
        a.show();
        b.show();
        b.setStockPrice(0);
        a.show();
        b.show();
    }
}
