package Leetcode;

import java.util.HashMap;

public class CombinationSumIV {

    HashMap<Integer , Integer> cache = new HashMap<>();

    public static void main(String[] args) {

        CombinationSumIV combinationSumIV = new CombinationSumIV();
        int[] candidates = new int[]{3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
        int target = 10;
        System.out.println(combinationSumIV.combinationSum4(candidates , target));
    }

    public int combinationSum4(int[] candidates, int target) {

        return  dfs(candidates ,target );
    }

    public int dfs (int[] candidates , int currentValue){

        if (cache.containsKey(currentValue)){
           return cache.get(currentValue);
        }

        int count = 0;
        if (currentValue == 0){
            return ++count;
        }

        for (int candidate : candidates) {
            if (currentValue - candidate >= 0) {
                count += dfs(candidates, currentValue - candidate);
            }
        }
        cache.put(currentValue,count);

        return count;
    }
}
