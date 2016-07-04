public class Solution {
    
    // Traditional method: TLE
    public int countPrimes2(int n) {
        int result = 0;
        for(int i = 2; i < n; i++) {
            if(isPrime(i))
                result++;
        }
        return result;
    }
    
    private boolean isPrime(int n) {
        if(n < 2) return false;
        
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
    
    // Sieve of Eratosthenes
    public int countPrimes(int n) {
        if(n < 2)
            return 0;
            
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int result = n - 2;
        
        for(int i = 2; i < n; i++) {
            if(isPrime[i] == false) {
                continue;
            }
            
            for(int j = 2; i * j < n; j++) {
                if(isPrime[i * j] == false)
                    continue;
                isPrime[i * j] = false;
                result--;
            }
        }
        
        return result;
    }
    
    
}