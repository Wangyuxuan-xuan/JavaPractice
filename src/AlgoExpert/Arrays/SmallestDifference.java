package AlgoExpert.Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class SmallestDifference {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallestDifference(
                new int[]{-1,5,10,20,28,3}
                , new int[]{26,134,135,15,17})));

        System.out.println(Arrays.toString(smallestDifferenceSort(
                new int[]{-1,5,10,20,28,3}
                , new int[]{26,134,135,15,17})));
    }

    /**
     * O(n*m) time , O(1) space , where n is the length of arrayOne and m is the length of arrayTwo
     *
     * Basic idea , double loop
     */
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {

        int[] resultArray = new int[2];
        int smallestDiff = -1;
        for (int numInArrayOne : arrayOne){

            for (int numInArrayTwo : arrayTwo){
                int currentDiff = Math.abs(numInArrayOne - numInArrayTwo);
                if (currentDiff < smallestDiff || smallestDiff == -1){
                    smallestDiff = currentDiff;
                    resultArray[0] = numInArrayOne;
                    resultArray[1] = numInArrayTwo;
                }
            }
        }

        return resultArray;
    }

    /**
     * O(nlog(n)+mlog(m)) time , O(1) space ,  where n is the length of arrayOne and m is the length of arrayTwo
     *
     * The basic idea is trying to make smaller interval in x-axis .
     * the distance between two num is always : bigger num - smaller num ,
     * we can make the interval/difference smaller by increase the smaller num .
     * (we can also decrease bigger num as well , but since our array is sorted ascending ,
     * it's easier to increase the smaller num by moving pointer to the right)
     *
     * Based on this idea , we will increase our smaller number by moving the pointer to the right by 1,
     * Both the number from arrayOne and arayTwo can become the smaller num ,
     * we can always increase by moving the pointer to the right by 1,
     * It's like the smaller num is chasing bigger num to reduce the gap :)
     */
    public static int[] smallestDifferenceSort(int[] arrayOne, int[] arrayTwo) {

        int[] resultArray = new int[2];
        int smallestDiff = Integer.MAX_VALUE;
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int arrayOneIdx = 0 , arrayTwoIdx = 0;
        while (arrayOneIdx < arrayOne.length && arrayTwoIdx < arrayTwo.length){
            int arrayOneValue = arrayOne[arrayOneIdx];
            int arrayTwoValue = arrayTwo[arrayTwoIdx];
            int currentDiff = Math.abs(arrayOneValue - arrayTwoValue);
            if (arrayOneValue < arrayTwoValue){
                arrayOneIdx++;
            }else if(arrayTwoValue < arrayOneValue){
                arrayTwoIdx++;
            }else {
                return new int[]{arrayOneValue,arrayTwoValue};
            }
            if (currentDiff < smallestDiff){
                smallestDiff = currentDiff;
                resultArray[0] = arrayOneValue;
                resultArray[1] = arrayTwoValue;
            }
        }
        return resultArray;
    }

}
