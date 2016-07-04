public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int rest = n;
        dfs(0, rest, n, sb, result);
        return result;
    }
    public void dfs(int count, int rest, int n, StringBuilder sb, List<String> result) {
        if(sb.length() == 2 * n && count == 0) {
            result.add(sb.toString());
            return;
        }
        if(count > 0) {
            sb.append(")");
            dfs(count - 1, rest, n, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(rest > 0) {
            sb.append("(");
            dfs(count + 1, rest - 1, n, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}