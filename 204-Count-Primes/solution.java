public class Solution {
    public int countPrimes(int n) {
        if(n < 2)
            return 0;
            
        boolean[] flags = new boolean[n];
        Arrays.fill(flags, true);
        int result = n - 2;
        
        for(int i = 2; i < n; i++) {
            if(flags[i] == false)
                continue;
            for(int j = 2; i * j < n; j++) {
                if(flags[i * j] == false)
                    continue;
                flags[i * j] = false;
                result--;
            }
        }
        
        return result;
        
    }
    
    
}