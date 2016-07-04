public class Solution {
    public int countPrimes(int n) {
        boolean[] flags = new boolean[n];
        Arrays.fill(flags, true);
        int result = 0;
        
        for(int i = 2; i < n; i++) {
            if(flags[i] == false)
                continue;
            for(int j = 2; i * j < n; j++) {
                flags[i * j] = false;
            }
        }
        
        for(int i = 2; i < n; i++) {
            if(flags[i] == true)
                result++;
        }
        return result;
        
    }
    
    
}