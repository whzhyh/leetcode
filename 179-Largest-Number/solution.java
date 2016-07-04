public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return "";
            
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strs[i] = nums[i] + "";
        }
        
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        
        int index = 0;
        while(index < strs.length - 1 && strs[index].equals("0"))
            index++;
            
        StringBuilder sb = new StringBuilder();
        for(int i = index; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        
        return sb.toString();
    }
}