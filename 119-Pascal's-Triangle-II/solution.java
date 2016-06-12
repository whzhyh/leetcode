public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        if(rowIndex < 0)
            return ans;
            
        List<Integer> prev = new ArrayList<>();
        
        for(int i = 0; i <= rowIndex; i++) {
            ans = new ArrayList<>();
            ans.add(1);
            for(int j = 1; j < i; j++) {
                ans.add(prev.get(j - 1) + prev.get(j));
            }
            if(i != 0)
                ans.add(1);
            prev = ans;
        }
        return ans;
    }
}