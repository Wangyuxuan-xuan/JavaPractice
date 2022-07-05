package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    //Put the list to global can make the code cleaner
    //It is actually the same if u put the list down as a parameter , since it's a reference
    List<List<Integer>> finalList = new ArrayList<>();
    List<Integer> currentList = new ArrayList<>();
    int size = 0;

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(new int[]{1,2,3}));
    }

    public List<List<Integer>> permute(int[] nums) {

//        dfs(nums);

        List<Integer> numList = new ArrayList<>();
        for(int num : nums){
            numList.add(num);
        }
        size = nums.length;
        dfsPermutation(numList );
        return finalList;
    }

    public void dfs (int[] nums){

        if (currentList.size() == nums.length){
            finalList.add(new ArrayList<>(currentList));
        }

        for(int currentNum : nums){

            if (currentList.contains(currentNum))
                continue;

            currentList.add(currentNum);
            dfs(nums);
            currentList.remove(currentList.size() - 1);

        }
    }

    //todo understand the time complexity
    public void dfsPermutation (List<Integer> nums ){

        if(currentList.size() == size){
            finalList.add(new ArrayList<>(currentList));
        }

        for (int i = 0; i < nums.size(); i++) {

            List<Integer> newList = new ArrayList<>(nums);
            newList.remove(i);

            currentList.add(nums.get(i));
            dfsPermutation(newList );
            currentList.remove(currentList.size() - 1);

        }
    }

}
