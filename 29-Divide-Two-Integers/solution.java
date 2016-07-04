public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor==0) return Integer.MAX_VALUE;
        
        if(divisor==-1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
            
        boolean isNegative = (dividend > 0) ^ (divisor > 0);
        
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        // System.out.println(b);
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