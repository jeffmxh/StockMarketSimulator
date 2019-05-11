/**
 * 
 */
package com;

/**
 * @author Jeffmxh
 * @Date 2019-05-05 16:52:25
 * @Description 
 *
 */
public class RandomTools {
    public static int randomInt(int lowerBound, int upperBound) {
        if (lowerBound > upperBound) {
            throw new IllegalArgumentException("The lowerBound provided is greater than upperBound!");
        } else {
            int result = (int)(Math.random() * (upperBound - lowerBound + 1) + lowerBound);
            return result;
        }
    }
    
    public static int randomIntAuto(int Bound1, int Bound2) {
        int start = Bound1 > Bound2 ? Bound2 : Bound1; 
        int end = Bound1 > Bound2 ? Bound1 : Bound2; 
        int result = (int)(Math.random() * (end - start + 1) + start);
        return result;
    }
    
    public static int nextIndex(int range) {
        int result = (int)(Math.random() * range);
        return result;
    }
}
