package AlgoExpert.Arrays;

public class MonotonicArray {

    public static void main(String[] args) {

    }

    /**
     * O(n) time, O(1) space
     */
    public static boolean isMonotonic(int[] array) {

        if (array.length < 2){
            return true;
        }
        boolean increasing = false , decreasing = false;
        for (int i = 1; i < array.length; i++) {
            if (array[i-1] < array[i]){
                increasing = true;
            }else if (array[i-1] > array[i]){
                decreasing = true;
            }
        }
        return !increasing || !decreasing;

    }

    /**
     * O(n) time , O(1) space , where n is the length of the array
     *
     * The basic idea is to loop through the array and see if the "direction" goes the same / non-opposite way
     * we can check if the "direction" goes non-opposite way by 看他们的乘积是否异号
     */
    public static boolean isMonotonicAnotherWay(int[] array) {

        if (array.length < 2){
            return true;
        }
        int direction = array[1] - array[0];
        for (int i = 2; i < array.length; i++) {
            if (direction == 0){
                direction = array[i] - array[i-1];
                continue;
            }
            //If we reach here , the direction cannot be 0 , it must have a value , positive or negative
            int currentDirection = array[i] - array[i-1];
            //如果两个direction异号，说明数列不单调
            if (direction * currentDirection < 0){
                return false;
            }

        }
        return true;
    }
}
