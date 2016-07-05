public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return ans;
        
        for(int i = 0; i < nums.length; ) {
            int j = i;
            
            for(; j + 1 < nums.length;) {
                if(nums[j + 1] - nums[j] == 1) {
                    j++;
                } else
                    break;
            }
            
            if(j > i) {
                ans.add(nums[i] + "->" + nums[j]);
            } else {
                ans.add(nums[j] + "");
                
            }
            i = j + 1;
        }
        
        return ans;
    }
}