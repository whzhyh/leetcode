public class Solution {
    
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) == num;
    }
    
    // Math
    public boolean isPowerOfFour1(int num) {
        double x = Math.log(num) / Math.log(4);
        return (num > 0) && (Math.abs(x - (int)(x + 0.5)) == 0);
    }
}