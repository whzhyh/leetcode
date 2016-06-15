public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int xor = 0;
        for(int i : nums) {
            xor ^= i;
        }
        
        int lastBit = xor & -xor; 
        // int lastBit = xor - (xor & (xor - 1));
        for(int i : nums) {
            if((lastBit & i) == 0) {
                result[0] ^= i;
            } else {
                result[1] ^= i;
            }
        }
        return result;
        
    }
}