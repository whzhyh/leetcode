public class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int min = 1;
        for(int i : nums) {
            if(i > 0) {
                set.add(i);
            }
        }

        while(true) {
            if(!set.contains(min++)) {
                return min - 1;
            }
        }
    }
}