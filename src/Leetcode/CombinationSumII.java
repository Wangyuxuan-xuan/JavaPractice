package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    List<List<Integer>> finalList = new ArrayList<>();
    List<Integer> currentList = new ArrayList<>();

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        int[] candidates = new int[]{2,5,2,1,2};
        int target = 5;
        System.out.println(combinationSumII.combinationSum2(candidates , target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        dfs(candidates,target , 0);
        return finalList;
    }

    public void dfs(int[] candidates, int currentValue , int j){

        if (currentValue == 0){
            finalList.add(new ArrayList<>(currentList));
        }

        for (int i = j; i < candidates.length; i++) {
            if (currentValue - candidates[i] >= 0){
                //why i > j : after choosing the current one , if the next one is the same with current one , then it may have duplication
                if (i > j && candidates[i] == candidates[i - 1])
                    continue;
                currentList.add(candidates[i]);
                //here we add j by i + 1 ,j will be assigned to next i we push the pointer to right by one , to make sure in the next call we won't choose ourself anymore
                dfs(candidates , currentValue - candidates[i] , i+1);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}
