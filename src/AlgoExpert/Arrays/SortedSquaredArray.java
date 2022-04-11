package AlgoExpert.Arrays;

import java.util.Arrays;

public class SortedSquaredArray {

    public static void main(String[] args) {

        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(sortedSquaredArray(array)));
    }

    /**
     * O(n) time , O(n) space
     * 以空间换时间
     * For sorted array we can consider using pointers
     */

    public static int[] sortedSquaredArray(int[] array) {

        int[] resultArray =  new int[array.length];
        int smallNumIdx = 0 ,largeNumIdx = array.length - 1;
        for (int currentIdx = array.length - 1; currentIdx >= 0 ; currentIdx--) {
            int largeNum = array[largeNumIdx];
            int smallNum = array[smallNumIdx];
            if (Math.abs(smallNum) > Math.abs(largeNum)){
                resultArray[currentIdx] = smallNum * smallNum;
                smallNumIdx++;
            }else {
                resultArray[currentIdx] = largeNum * largeNum;
                largeNumIdx--;
            }
        }
        return resultArray;
    }

    /**
     * O(nlog(n)) time , O(1) space
     */
    public static int[] sortedSquaredArraySmallSpace(int[] array) {

        for (int i = 0; i < array.length; i++) {
            array[i] = array[i]*array[i];
        }
        Arrays.sort(array);
        return array;
    }
}
