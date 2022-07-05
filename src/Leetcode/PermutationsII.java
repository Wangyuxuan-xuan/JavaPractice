package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    List<List<Integer>> finalList = new ArrayList<>();
    List<Integer> currentList = new ArrayList<>();
    int size = 0;

    public static void main(String[] args) {
        PermutationsII permutationsII = new PermutationsII();
        System.out.println(permutationsII.permuteUnique(new int[]{1,2,3}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> numList = new ArrayList<>();
        for(int num : nums){
            numList.add(num);
        }
        size = nums.length;
        dfs(numList );
        return finalList;
    }

    public void dfs (List<Integer> nums ){

        if(currentList.size() == size){
            finalList.add(new ArrayList<>(currentList));
        }

        int previousNum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {

            int currentNum = nums.get(i);

            if (nums.get(i) == previousNum)
                continue;

            previousNum = currentNum;
            List<Integer> newList = new ArrayList<>(nums);
            newList.remove(i);

            currentList.add(currentNum);
            dfs(newList );
            currentList.remove(currentList.size() - 1);

        }
    }


}
