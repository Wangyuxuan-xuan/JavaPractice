package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeNumSum {

    public static void main(String[] args) {
        int[] array = new int[]{12,3,1,2,-6,5,-8,6};
        int targetSum = 0;
        List<Integer[]> list = threeNumberSum(array,targetSum);
        System.out.println(list.size());
        for (Integer[] integers : list) {
            System.out.println(Arrays.toString(integers));
        }
//        System.out.println(threeNumberSum(array,targetSum));
    }

    /**
     * The idea is to use three pointers , and use one of them(here we choose the left of them , as it's the smallest )
     * as the "constant" , so we can simplify our problem to a two number sum in the loop and use the same window sliding
     */

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

        Arrays.sort(array);
        ArrayList<Integer[]> result = new ArrayList<>();

        for (int i = 0; i < array.length-2 ;i++){
            int left = i + 1, right = array.length-1;
            while (left < right){
                int currentSum = array[i] + array[left] + array[right];
                if(currentSum == targetSum){
                    result.add(new Integer[]{array[i] , array[left],array[right]});
                    //The left or right have to change , other wise currentSum will always = targetSum ,
                    // it will be an infinate loop
                    //And we have to move both pointers as well , as the current state is the point that we reach to targetSum,
                    //if we just move one of the pointer it will absolutely not be equal to targetSum .
                    left++;
                    right--;
                }else if(currentSum < targetSum){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return result;
    }
}
