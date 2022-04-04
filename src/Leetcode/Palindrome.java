package Leetcode;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(11011));
    }

    /**
     *Compare with String , convert it to char array is much faster, since we don't need to call charAt function everytime
     *
     * Runtime: 7 ms, faster than 90.12% of Java online submissions for Palindrome Number.
     * Memory Usage: 42.1 MB, less than 82.39% of Java online submissions for Palindrome Number.
     */
    public static boolean isPalindrome(int x){

        char[] digits = String.valueOf(x).toCharArray();
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != digits[digits.length-1-i]){
                return false;
            }
        }
        return true;
    }

    /**
     * 数组下表为一个起始项为0的等差数列，中位数 = 平均数 = (0+length-1)/2 = (length-1)/2
     * 注意相除时要cast为int ， 否则小数点会被丢掉而出错
     * 0 < (2-1)/2 == false
     */
    public static boolean isPalindromeHalfLoop(int x){

        char[] digits = String.valueOf(x).toCharArray();

        for (int i = 0; i < (float) (digits.length-1)/2; i++) {
            if (digits[i] != digits[digits.length-1-i]){
                return false;
            }
        }
        return true;
    }

    /**
     * Your runtime beats 40.56 % of java submissions
     * Your memory usage beats 25.24 % of java submissions.
     */
    public static boolean isPalindromeStringVersion(int x){
        String s = String.valueOf(x);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeReverse(int x) {
        String s = String.valueOf(x);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s);

        String reverse = String.valueOf(stringBuilder.reverse());

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != reverse.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
