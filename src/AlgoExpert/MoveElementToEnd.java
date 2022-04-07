package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MoveElementToEnd {

    public static void main(String[] args) {

        List<Integer> arrayList = moveElementToEndSimplify(new ArrayList<>(Arrays.asList(2,1,2,2,2,3,4,2)),2);
        for (Integer integer : arrayList) {
            System.out.println(integer);
        }

    }

    /**
     * O(nlog(n) + m) time , O(1) space , where n is the length of array and m is the time of occurrence of toMove
     */

    public static List<Integer> moveElementToEndSimplify(List<Integer> array, int toMove) {

        array.sort(Comparator.naturalOrder());
        int startIdx = -1 , endIdx = -1 ;
        boolean get = false;
        for (int i = 0; i < array.size(); i++) {
            if (!get && array.get(i).equals(toMove)){
                startIdx = i;
                get = true;
            }else if(get && array.get(i) > toMove){
                endIdx = i-1;
                break;
            }
        }

        if (startIdx != -1 && endIdx != -1){
            array.subList(startIdx,endIdx+1).clear();

            for (int i = 0; i < endIdx - startIdx + 1; i++) {
                array.add(toMove);
            }

        }

        return array;
    }

    /**
     * O(n+m)time , O(n) space , where n is the length of array and m is the time of occurrence of toMove
     */
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {

        int count = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (Integer integer : array){
            if (integer.equals(toMove)){
                count++;
            }else {
                arrayList.add(integer);
            }
        }
        for (int i = 0; i < count; i++) {
            arrayList.add(toMove);
        }

        return arrayList;
    }

    /**
     * This method is a wrong implementation
     *
     * It is not recommended adding or removing elements from a list within a loop as an index of its elements,
     * and the length of the list is changed. This might lead to the incorrect output,
     * or java.util.IndexOutOfBoundsException or java.util.ConcurrentModificationException will be thrown
     * to avoid non-deterministic behavior at later stage.
     */

    public static List<Integer> moveElementToEndSimplifyWrong(List<Integer> array, int toMove) {

        int count = 0;

        //It is not recommended adding or removing elements from a list within a loop as an index of its elements,
        // and the length of the list is changed. This might lead to the incorrect output,
        // or java.util.IndexOutOfBoundsException or java.util.ConcurrentModificationException will be thrown
        // to avoid non-deterministic behavior at later stage.
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).equals(toMove)){
                array.remove(i);
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            array.add(toMove);
        }

        return array;
    }

}
