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
     * When looping from left to right , all the value in array are replaced with the product of all its left numbers ,
     * what's missing there is the product of its right numbers .
     * To add the right products , we simply loop again from right to left , adding the right product to the value ,
     * the same way as left product , Now we have our result
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
