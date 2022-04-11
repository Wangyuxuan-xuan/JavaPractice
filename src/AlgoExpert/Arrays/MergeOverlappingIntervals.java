package AlgoExpert.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2},{3,5},{4,7},{6,8},{9,10}};
        System.out.println(Arrays.deepToString(mergeOverlappingIntervals(intervals)));

        //因其已经指向地址，所以我们可以直接修改已经add进ArrayList的array ， 而不需要使用set
        ArrayList<int[]> arrayList = new ArrayList<>();
        arrayList.add(new int[]{1,2,3,4});
        int [] current = arrayList.get(0);

        current[1] = 200000000;

        for (int[] ints : arrayList) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {

        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> results = new ArrayList<>();
        int[] currentInterval = intervals[0];
        results.add(currentInterval);

        for(int[] nextInterval : intervals){
            if (currentInterval[1] >= nextInterval[0]){
                currentInterval[1] = Math.max(currentInterval[1] , nextInterval[1]);
            }else {
                currentInterval = nextInterval;
                results.add(currentInterval);
            }
        }

        return results.toArray(new int[0][0]);
    }
}
