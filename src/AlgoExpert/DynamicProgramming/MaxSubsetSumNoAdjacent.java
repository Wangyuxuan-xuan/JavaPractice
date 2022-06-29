package AlgoExpert.DynamicProgramming;

public class MaxSubsetSumNoAdjacent {

    public static void main(String[] args) {
        System.out.println(maxSubsetSumNoAdjacent(new int[]{75 ,105 ,120 ,75 ,90 ,135}));
    }

    /**
     * Time O(n) Space O(1)
     *
     * @param array the input array of positive integers
     * @return the maximum sum of non-adjacent elements of the array
     */
    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array.length == 0){
            return 0;
        }else if (array.length == 1){
            return array[0];
        }

        int maxSumTillCurrentIndex = Math.max(array[0], array[1]);
        int maxSumTillPreviousIndex = array[0];

        for (int i = 2; i < array.length; i++) {
            int currentMax = Math.max(maxSumTillCurrentIndex , maxSumTillPreviousIndex + array[i]);
            maxSumTillPreviousIndex = maxSumTillCurrentIndex;
            maxSumTillCurrentIndex = currentMax;
        }

        return maxSumTillCurrentIndex;
    }

}
