public class Solution {
    // Math, it seems that this method works for only prime numbers.
    public boolean isPowerOfTwo(int n) { 
        return n > 0 && (1073741824 % n == 0);
    }
    // Iterative
    public boolean isPowerOfTwo2(int n) {
        if(n <= 0)
            return false;
            
        while(n % 2 == 0) {
            n /= 2;
        }
            
        return n == 1;
    }
    
    // Recursion
    public boolean isPowerOfTwo3(int n) {
        return (n > 0) && (n == 1 || (n % 2 == 0 && isPowerOfTwo(n / 2)));
    }
    // Bit Manipulation
    public boolean isPowerOfTwo1(int n) {
        return (n > 0) && (n & (n - 1)) == 0;
    }
}