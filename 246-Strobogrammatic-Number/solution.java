public class Solution {
    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        
        int i = 0, j = num.length() - 1;
        while(i <= j) {
            char ci = num.charAt(i);
            char cj = num.charAt(j);
            if(!map.containsKey(ci))
                return false;
            if(cj != map.get(ci))
                return false;
            i++;
            j--;
        }
        return true;
    }
}