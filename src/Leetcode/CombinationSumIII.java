package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    List<List<Integer>> finalList = new ArrayList<>();
    List<Integer> currentList = new ArrayList<>();


    public static void main(String[] args) {
        CombinationSumIII combinationSumIII = new CombinationSumIII();
        int k = 3;
        int target = 9;
        System.out.println(combinationSumIII.combinationSum3(k, target));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {

        dfs(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, n, k, 0);
        return finalList;
    }

    public void dfs(int[] candidates, int currentValue, int remainingLimit, int j) {

        if (remainingLimit == 0 && currentValue == 0) {
            finalList.add(new ArrayList<>(currentList));
        }

        for (int i = j; i < candidates.length; i++) {
            if (remainingLimit > 0 && currentValue - candidates[i] >= 0) {
                currentList.add(candidates[i]);
                dfs(candidates, currentValue - candidates[i], remainingLimit - 1, i + 1);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}
