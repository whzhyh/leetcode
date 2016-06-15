public class Solution {
    public boolean isPowerOfThree(int n) {
        double x = Math.log(n) / Math.log(3);
        return (n > 0) && (Math.abs(x - (int)(x + 0.5)) < 1e-10);
    }
}