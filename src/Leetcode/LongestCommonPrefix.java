package Leetcode;

import java.util.ArrayList;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String [] stringArray = new String[]{"ac","ac","a","a"};
        System.out.println(longestCommonPrefix(stringArray));
    }

    public static String longestCommonPrefix(String[] strs) {
        ArrayList<Character> resultArray = new ArrayList<>();

        if (strs.length == 1){
            return strs[0];
        }
        if(strs.length > 1){
            char [] charactersPre = strs[0].toCharArray();
            char [] charactersAft = strs[1].toCharArray();
            for (int k = 0; k < charactersPre.length && k < charactersAft.length; k++) {
                if (charactersPre[k] == charactersAft[k]){
                    resultArray.add(charactersPre[k]);
                }else {
                    break;
                }
            }

            if (strs.length > 2){
                for (int i = 2; i < strs.length; i++) {
                    char [] characters = strs[i].toCharArray();
                    for (int j = 0; j < resultArray.size(); j++) {
                        if(characters.length == 0){
                            return "";
                        }
                        else if(characters.length >= resultArray.size() && characters[j] != resultArray.get(j)){
                            resultArray.subList(j,resultArray.size()).clear();
                        }else if(characters.length < resultArray.size()){
                            resultArray.subList(characters.length,resultArray.size()).clear();
                            if(characters[j] != resultArray.get(j)){
                                resultArray.subList(j,resultArray.size()).clear();
                            }
                        }
                    }
                }
            }

        }

        StringBuilder stringBuilder = new StringBuilder(resultArray.size());
        for(Character character : resultArray){
            stringBuilder.append(character);
        }

        return  stringBuilder.toString();
    }
}
