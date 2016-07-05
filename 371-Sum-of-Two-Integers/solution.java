public class Solution {
    public int getSum(int a, int b) {
        if(a == 0)
            return b;
        if(b == 0)
            return a;
            
        int sum = a^b; // find the different digits;
        int carry = (a&b)<<1; // find the same digits, and shift it to right by 1.
        
        return getSum(sum, carry);
    }
}