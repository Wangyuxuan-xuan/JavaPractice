package AlgoExpert.Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstDuplicateValue {

    public static void main(String[] args) {
        System.out.println(firstDuplicateValue(new int[]{2,1,5,2,3,3,4}));
    }

    /**
     * O(n) time ,O(n) space , where n is the length of input array
     *
     * Time Complexity of HashSet Operations: The underlying data structure for HashSet is hashtable.
     * So amortize (average or usual case) time complexity for add, remove and
     * look-up (contains method) operation of HashSet takes O(1) time.
     */
    public static int firstDuplicateValueHashSet(int[] array) {

        Set<Integer> set = new HashSet<>();

        for (int integer: array) {
            if (set.add(integer)) {
                continue;
            }
            return integer;
        }

        return -1;
    }

    /**
     * O(n) time , O(1) space , where n is the length of array
     *
     * 数学思想，一一对应关系.
     * Since all the input value are between 1 and n , index abs(currentValue) - 1 is still in bound ,
     * 我们可以改变相应数字的符号 ， 来记录相应的数字是否出现过。
     * 因为其一一对应关系， 当改变符号时若发现其已经变号， 则说明当前数字已经出现过，即为重复。
     */
    public static int firstDuplicateValue(int[] array) {

        for (int currentValue : array){
            int absolute = Math.abs(currentValue);
            if (array[absolute - 1] < 0){
                return absolute;
            }
            array[absolute - 1] *= -1;
        }
        return -1;
    }
}
