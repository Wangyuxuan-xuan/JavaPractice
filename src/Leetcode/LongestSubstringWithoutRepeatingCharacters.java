package Leetcode;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("bpfbhmipx"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()){
            return 0;
        }
        Set<Character> resultSet = new HashSet<>();
        List<Character> list = new ArrayList<>();
        int maxLength = 0;
        for (Character c : s.toCharArray()) {
            if (resultSet.add(c)){
                list.add(c);
                if (maxLength < resultSet.size()){
                    maxLength = resultSet.size();
                }

            }else {
                resultSet.clear();
                List<Character> temp = new ArrayList<>();
                for (int i = list.indexOf(c) + 1; i < list.size(); i++) {
                    resultSet.add(list.get(i));
                    temp.add(list.get(i));
                }
                list.clear();
                list.addAll(temp);
                list.add(c);
                resultSet.add(c);
            }
        }
        return maxLength;
    }
}
