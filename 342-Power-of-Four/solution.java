public class Solution {
    public boolean isPowerOfFour(int num) {
        double x = Math.log(num) / Math.log(4);
        return (num > 0) && (Math.abs(x - (int)(x + 0.5)) == 0);
    }
}