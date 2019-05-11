/**
 * Define the object for order, to transfer the information
 * when trading.
 */
package com;



/**
 * @author Jeffmxh
 * @Date 2019-05-05 10:15:38
 * @Description 
 * 
 */
public class Order implements Cloneable, Comparable<Order> {
    /**
     *
     */
    private int personId;
    private int stockCode;
    private int stockNum;
    double stockPrice;

    public Order(Integer personId, int stockCode, int stockNum, double stockPrice) {
        if (stockCode < 0) {
            throw new IllegalArgumentException("Illegal stock code provided!");
        } else {
            this.personId = personId;
            this.stockCode = stockCode;
            this.stockNum = stockNum;
            this.stockPrice = stockPrice;
        }
    }

    @Override
    public int compareTo(Order o) {
        if (this.stockPrice != o.getStockPrice()) {
            return this.stockPrice > o.getStockPrice() ? 1 : -1;
        }
        return 0;
    }

    @Override
    public Object clone() {
        Object o = null;
        try {
            o = (Order) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        return o;
    }
    public void setStockPrice(double newPrice) {
        stockPrice = newPrice;
    }

    public void update(int stockChange) {
        stockNum += stockChange;
    }

    public void show() {
        System.out.print("PersonId: " + personId + "  ");
        System.out.print("StockCode: " + stockCode + "  ");
        System.out.print("StockNum: " + stockNum + " ");
        System.out.println("StockPrice: " + stockPrice);
    }

    public int getPersonId() {
        return personId;
    }

    public int getStockCode() {
        return stockCode;
    }

    public int getStockNum() {
        return stockNum;
    }

    public double getStockPrice() {
        return stockPrice;
    }
}
