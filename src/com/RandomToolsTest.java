/**
 * 
 */
package com;

/**
 * @author Jeffmxh
 * @Date 2019-05-05 16:57:02
 * @Description 
 *
 */
public class RandomToolsTest {
    public static void main(String[] args) {
        for(int i = 1; i < 10; i++) {
            System.out.print(RandomTools.randomInt(0, 5) + " ");
        }
        System.out.print("\n");
        
        for(int i = 1; i < 10; i++) {
            System.out.print(RandomTools.randomIntAuto(10, 5) + " ");
        }
        System.out.print("\n");
        
        for(int i = 1; i < 10; i++) {
            System.out.print(RandomTools.nextIndex(5) + " ");
        }
        for(int i = 1; i < 10; i++) {
            if (Math.random() > 0.8) {
                System.out.print("aaa ");
            }
        }
    }
}
