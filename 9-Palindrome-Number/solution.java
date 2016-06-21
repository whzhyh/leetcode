public class Solution {
    public boolean isPalindrome(int x) {
        int y = 0;
        int x2 = x;
        while(x2 > 0) {
            y = y * 10 + x2 % 10;
            x2 /= 10;
        }
        return x == y;
    }
}