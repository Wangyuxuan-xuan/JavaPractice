package Leetcode;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("("));
    }

    /**
     * The basic idea is to push the right parentheses ')', ']', or '}' into the stack each time when we encounter left ones.
     * And if a right bracket appears in the string, we need check if the stack is empty
     * and also whether the top element is the same with that right bracket.
     * If not, the string is not a valid one. At last, we also need check if the stack is empty.
     *
     * And adding an odd string length check is better
     */
    public boolean isValidSimple(String s) {
        if (s.toCharArray().length % 2 == 1){
            return false;
        }

        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    /**
     * Runtime: 2 ms, faster than 82.42% of Java online submissions for Valid Parentheses.
     * Memory Usage: 42 MB, less than 52.05% of Java online submissions for Valid Parentheses.
     */
    public static boolean isValid(String s) {

        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char c : charArray) {
            if (stack.empty()){
                stack.push(c);
            }else {
                char top = stack.peek();
                if (isPair(top,c)){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
        }
        return stack.empty();
    }

    public static boolean isPair(char top , char next){
        return switch (next) {
            case ')' -> top == '(';
            case ']' -> top == '[';
            case '}' -> top == '{';
            default -> false;
        };

    }
}
