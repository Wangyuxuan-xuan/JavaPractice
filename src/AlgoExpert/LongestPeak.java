package AlgoExpert;

public class LongestPeak {

    public static void main(String[] args) {

        System.out.println(longestPeak(new int[]{1,2,3,3,4,0,10,6,5,-1,-3,2,3}));
    }

    /**
     * O(n) time , O(1) space , where n is the length of input array ;
     */
    public static int longestPeak(int[] array) {

        int longestLength = 0 ;
        boolean isPeak = false ;
        int i = 1;
        while (i < array.length - 1){

            isPeak = array[i - 1] < array [i] && array[i] > array[i + 1];
            if (!isPeak){
                i++;
                continue;
            }

            int leftMost = i - 1, rightMost = i + 1;
            while (leftMost > 0 && array[leftMost] > array[leftMost - 1]){
                leftMost --;
            }

            while (rightMost < array.length - 1 && array[rightMost] > array[rightMost + 1]){
                rightMost ++;
            }
            int currentLength = rightMost - leftMost + 1;
            if (currentLength > longestLength){
                longestLength = currentLength;
            }
            i = rightMost + 1;
        }

        return longestLength;
    }
}
