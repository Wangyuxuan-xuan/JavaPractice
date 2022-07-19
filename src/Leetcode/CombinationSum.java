package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

        CombinationSum combinationSum = new CombinationSum();

        int[] candidates = new int[]{1,2,2,2,5};
        int target = 5;
        Arrays.sort(candidates);

        List<List<Integer>> results =  combinationSum.combinationSum(candidates , target);

        System.out.println(results);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> results = new ArrayList<>();
        dfs(0 , candidates , target , results , new ArrayList<Integer>());

        return results;
    }

    public void dfs (int j , int[] candidates , int target , List<List<Integer>> finalList , ArrayList<Integer> currentList){
        if (j >= candidates.length){
            return;
        }
        if (target == 0){
            //We have to make a copy here , because
            // everytime we delete the currentList , it will affect here also (if we don't copy)
            finalList.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = j; i < candidates.length; i++) {

            if (target - candidates[i] >= 0 ){
                currentList.add(candidates[i]);
                dfs(i , candidates , target - candidates[i] , finalList , currentList);
                //in dynamic programming , we should divide the problem into indepedent subproblems
                //we should delete here because we don't want the branch to affect each other
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}
