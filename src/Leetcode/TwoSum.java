package Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int [] nums = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSumArraySolution(nums, target)));
        System.out.println(Arrays.toString(twoSumHashmapSolution(nums, target)));
    }

    public static int[] twoSumArraySolution(int[] nums, int target) {
        int [] results = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    results[0] = i;
                    results[1] = j;
                }
            }
        }
        return results;
    }

    public static int[] twoSumHashmapSolution(int[] nums, int target) {
        int [] results = new int[2];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(target - nums[i])){
                results[0] = i;
                results[1] = hashMap.get(target - nums[i]);
            }
            hashMap.put(nums[i], i);
        }

        return results;
    }
}
