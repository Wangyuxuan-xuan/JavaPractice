package Collection;

import java.util.Arrays;

public class SortingAlgorithms {

    public static void main(String[] args) {

        int[] array = new int[]{10,2,3,1,-5,9,3,5};
//        insertionSort(array);
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * Time O(n^2) Space O(n)
     *
     * loop from left to right , find the correct location for current var and insert it into the array , shift the rest right
     */
    public static void insertionSort(int[] array){

        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1 ;
            for (; j >= 0 && current < array[j]; j--) {
                array[j+1] = array[j];
            }
            array[j + 1] = current;
        }
    }

    /**
     * Time O(n^2) space O(n)
     */
    public static void bubbleSort(int[] array){

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i -1; j++) {
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    
}
