package AlgoExpert;

import java.util.Arrays;

public class ArrayOfProducts {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayOfProductsDoubleLoop(new int[]{5, 1, 4, 2})));
        System.out.println(Arrays.toString(arrayOfProductsLeftAndRight(new int[]{5, 1, 4, 2})));
    }

    /**
     * O(n^2) time , O(n) space
     */
    public static int[] arrayOfProductsDoubleLoop(int[] array) {

        int[] result = new int[array.length];

        for (int i = 0; i < result.length; i++) {
            int newResult = 1 ;
            for (int j = 0; j < result.length; j++) {
                if (i != j){
                    newResult *= array[j];
                }
            }
            result[i] = newResult;
        }

        return result;
    }

    /**
     * O(n) time , O(n) space , where n is the length of array.
     *
     * the basic idea is 
     */
    public static int[] arrayOfProductsLeftAndRight(int[] array) {

        int[] product = new int[array.length];
        int[] leftProduct = new int[array.length];
        int[] rightProduct = new int[array.length];

        int leftCumulativeProduct = 1 ;
        for (int i = 0; i < array.length; i++) {
            leftProduct[i] = leftCumulativeProduct;
            leftCumulativeProduct *= array[i];
        }

        int rightCumulativeProduct = 1 ;
        for (int i = array.length - 1; i >= 0; i--) {
            rightProduct[i] = rightCumulativeProduct;
            rightCumulativeProduct *= array[i];
        }

        for (int i = 0; i < array.length; i++) {
            product[i] = leftProduct[i] * rightProduct[i];
        }

        return product;
    }
}
