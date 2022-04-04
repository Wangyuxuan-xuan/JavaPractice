package Leetcode;

public class RomanToInteger {
    public static void main(String[] args) {
        //IV IX XL XC CD CM
        System.out.println(romanToInt("MCMXCIV"));
    }
    public static int romanToInt(String s) {
        int result = 0;
        char [] digits;
        digits = s.toCharArray();
        for (int i = 0; i < digits.length; i++) {
            if(digits[i] == 'I'){
                if(i + 1 < digits.length && digits[i + 1] == 'V'){
                    result += -1;
                }else if(i + 1 < digits.length &&digits[i + 1] == 'X'){
                    result += -1;
                }else {
                    result += 1;
                }

            }else if (digits[i] == 'V'){
                result += 5;
            }else if (digits[i] == 'X'){
                if(i + 1 < digits.length && digits[i + 1] == 'L'){
                    result += -10;
                }else if(i + 1 < digits.length && digits[i + 1] == 'C'){
                    result += -10;
                }else {
                result += 10;
                }
            }

            else if (digits[i] == 'L'){
                result += 50;
            }

            else if (digits[i] == 'C'){
                if(i + 1 < digits.length && digits[i + 1] == 'D'){
                    result += -100;
                }else if(i + 1 < digits.length && digits[i + 1] == 'M'){
                    result += -100;
                }else {
                result += 100;
                }
            }

            else if (digits[i] == 'D'){
                result += 500;
            }

            else if (digits[i] == 'M'){
                result += 1000;
            }
        }
        return result;
    }
}
