public class Solution {
    
    public int divide(int dividend, int divisor) { 
        if(divisor == 0) return Integer.MAX_VALUE;
        
        if(divisor == -1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        
        boolean isNegative = (dividend > 0) ^ (divisor > 0);
        
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int result = 0;
        
        while(a >= b) {
            int shift = 0;
            while(a >= (b << shift)) {
                shift++;
            }
            a -= b << (shift - 1);
            result += 1 << (shift - 1);
        }
        
        return isNegative ? -result : result;
    }
    
    // Binary Search
    public int divide2(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        
        if(divisor == -1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
            
        boolean isNegative = (dividend > 0) ^ (divisor > 0);
        
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        
        long start = 0, end = a;
        int result = 0;
        
        while(start + 1 < end) {
            long mid = start + (end - start) / 2;
            long r = mid * b;
            if(r == a) {
                result = (int)mid;
                break;
            } else if(r > a) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if(result == 0) {
            if(end * b > a) {
                result = (int)start;
            } else 
                result = (int)end;    
        }
        
        return isNegative ? -result : result;
        
    }
}