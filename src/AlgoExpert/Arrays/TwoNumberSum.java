package AlgoExpert.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TwoNumberSum {

    public static void main(String[] args) {

        int[] array = new int[]{3,5,-4,8,11,1,-1,6};
        int targetSum = 10;
        System.out.println(Arrays.toString(twoNumberSumHashMap(array, targetSum)));
    }

    /**
     *O(n) time , O(n) space
     * Good solution for large input set and enough space
     */

    public static int[] twoNumberSumHashMap(int[] array, int targetSum) {

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            hashMap.put(array[i],i);
        }

        for (Integer integer : hashMap.keySet()){
            if (hashMap.containsKey(targetSum-integer)){
                return new int[]{integer,targetSum-integer};
            }
        }
        return new int[0] ;
    }

    /**
     * O(n) time , O(n) space
     * Good solution for large input set and enough space
     */
    public static int[] twoNumberSumHashSet(int[] array, int targetSum){

        HashSet<Integer> hashSet = new HashSet<>();
        for(Integer integer : array){
            int potentialSum = targetSum - integer;
            if (hashSet.contains(potentialSum)){
                return new int[]{integer,potentialSum};
            }else {
                hashSet.add(integer);
            }
        }
        return new int[0];
    }

    /**
     * O(nlog(n)) time ,  O(1) space;
     * Better for iterative solution , for limited space and affordable time
     */

    public static int[] twoNumberSumDoublePointers(int[] array, int targetSum){

        Arrays.sort(array);
        int left = 0 , right = array.length-1;
        while (left < right){
            int currentSum = array[left] + array[right];
            if (currentSum == targetSum){
                return new int[]{array[left],array[right]};
            }else if(currentSum < targetSum){
                left++;
            }else {
                right--;
            }
        }
        return new int[0];
    }

    /**
     * O(n^2) time , O(1) space
     * Good for small array with limited space;
     */
    public static int[] twoNumberSumIterative(int[] array, int targetSum){

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == targetSum){
                    return new int[]{array[i],array[j]};
                }
            }
        }

        return new int[0];
    }
}
