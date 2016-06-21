public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        for(String s : tokens) {
            if(!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/"))
                stack.push(Integer.parseInt(s));
            else {
                int right = stack.pop();
                int left = stack.pop();
                switch (s) {
                    case "+":
                        result = left + right;
                        break;
                    case "-":
                        result = left - right;
                        break;
                    case "*":
                        result = left * right;
                        break;
                    case "/":
                        result = left / right;
                        break;
                }
                stack.push(result);
            }
        }
        return stack.peek();
    }
}