package Leetcode;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("dvdaf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()){
            return 0;
        }
        List<Character> resultList = new ArrayList<>();
        int maxLength = 0;
        for (Character c : s.toCharArray()) {
            if (!resultList.contains(c)){
                resultList.add(c);
                if (maxLength < resultList.size()){
                    maxLength = resultList.size();
                }
            }else {
                resultList.subList(0,resultList.indexOf(c)+1).clear();
                resultList.add(c);
            }
        }
        return maxLength;
    }
}
