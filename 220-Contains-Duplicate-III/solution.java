public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length < 2 || k <= 0 || t < 0)
            return false;
        
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if((set.floor(n) != null && n <= t + set.floor(n)) ||
            (set.ceiling(n) != null && set.ceiling(n) <= t + n))
                return true;
            set.add(n);
            if(i >= k)
                set.remove(nums[i - k]);
        }
        return false;
        
    }
}