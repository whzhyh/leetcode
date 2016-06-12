public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows <= 0)
            return ans;
        
        for(int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for(int j = 1; j < i - 1; j++) {
                List<Integer> prev = ans.get(ans.size() - 1);
                list.add(prev.get(j - 1) + prev.get(j));
            }
            if(i != 1)
                list.add(1);
            ans.add(list);
        }
        return ans;
        
    }
}