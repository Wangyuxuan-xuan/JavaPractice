package Leetcode;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("dvdaf"));
        int i = 0;
        ArrayList arrayList = new ArrayList<>(Arrays.asList(0,1,2,3));
        System.out.println(arrayList.get(i++));

        System.out.println(lengthOfLongestSubstringTwoPointersSolution("dvdaf"));
    }

    /**
     * Runtime: 19 ms, faster than 26.52% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 44.7 MB, less than 56.82% of Java online submissions for Longest Substring Without Repeating Characters.
     */
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

    /**
     * Two pointer solution ,line sliding a window
     *
     * we have left pointer lPointer and right pointer rPointer from the beginning .
     * Right pointer : move and add element to set until we meet a duplication
     * Left pointer : move when we have duplication and delete element until duplication is eliminated.
     * maxLength will record the longest size of our set .
     *
     * Runtime: 6 ms, faster than 79.29% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 42.5 MB, less than 88.30% of Java online submissions for Longest Substring Without Repeating Characters.
     */
    public static int lengthOfLongestSubstringTwoPointersSolution(String s){
        int lPointer =0 , rPointer = 0 , maxLength = 0;

        Set<Character> set = new HashSet<>();
        while (rPointer < s.length()){
            if (!set.contains(s.charAt(rPointer))){
                set.add(s.charAt(rPointer));
                rPointer++;
                maxLength = Math.max(maxLength,set.size());
            }else {
                set.remove(s.charAt(lPointer));
                lPointer++;
            }
        }
        return maxLength;
    }
}
