/**
 * 
 */
package com;


/**
 * @author Jeffmxh
 * @Date 2019-05-11 10:30:51
 * @Description 
 *
 */
public class Temp {
    public static void main(String[] args) {
        int a;
        a = f();
        System.out.println(a);
    }
    public static int f(){
        try {
           return 5/0;
        }catch(Exception e) {
            return 6;
        }finally {
            return 3;
        }
    }
}
