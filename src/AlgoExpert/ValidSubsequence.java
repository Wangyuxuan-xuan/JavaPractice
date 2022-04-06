package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidSubsequence {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(1,2,3,4));
        List<Integer> sequence =  new ArrayList<>(Arrays.asList(2,3));
        System.out.println(isValidSubsequence(array,sequence));
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        if (array.size() < sequence.size()){
            return false;
        }
        int i = 0;
        for(Integer integer : array){
            if(integer.equals(sequence.get(i))){
                i++;
            }else if(i == sequence.size()-1){
                return true;
            }
        }
        return false;
    }
}
