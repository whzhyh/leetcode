public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return "";
        Integer[] nums2 = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i];
        }
        Arrays.sort(nums2, new Comparator<Integer>(){
            public int compare(Integer x1, Integer x2) {
                String s1 = x1 + "" + x2;
                String s2 = x2 + "" + x1;
    
                return -s1.compareTo(s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i : nums2) {
            sb.append(i);
        }
        
        while(sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        
        return sb.toString();
    }
}