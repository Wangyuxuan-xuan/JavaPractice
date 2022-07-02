package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = new int[]{2,3,5};
        int target = 8;
        System.out.println(combinationSum.combinationSum(candidates , target));
    }

    List<List<Integer>> finalList = new ArrayList<>();
    List<Integer> currentList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {


        dfs(candidates ,target , 0);
        return finalList;
    }

    public void dfs (int[] candidates , int currentValue , int j){

        if (currentValue == 0){
            finalList.add(new ArrayList<>(currentList));
        }

        for (int i = j; i < candidates.length; i++) {
            if (currentValue - candidates[i] >= 0){
                currentList.add(candidates[i]);
                dfs(candidates ,currentValue - candidates[i] , i);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}
