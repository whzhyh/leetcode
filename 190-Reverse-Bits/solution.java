public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int left = 0, right = 31;
        while(left < right) {
            boolean isLeftOne = getBit(n, left);
            boolean isRightOne = getBit(n, right);

            n = updateBit(n, left, isRightOne);
            n = updateBit(n, right, isLeftOne);
            left++;
            right--;
        }
        return n;
    }
    
    public boolean getBit(int n, int k) {
        return (n & (1 << k)) != 0;
    }
    
    public int updateBit(int n, int k, boolean isOne) {
        int value = isOne ? 1 : 0;
        int mask = ~(1 << k);
        return n & mask | (value << k);
    }
}