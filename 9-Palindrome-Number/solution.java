public class Solution {
    public boolean isPalindrome(int x) {
        int reversed = 0;
        int copy = x;
        while(copy > 0) {
            reversed = reversed * 10 + copy % 10;
            copy /= 10;
        }
        return x == reversed;
    }
}