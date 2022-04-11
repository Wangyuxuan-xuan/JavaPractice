package AlgoExpert.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ValidSubsequence {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(1,2,3,4,-1,3,4));
        List<Integer> sequence =  new ArrayList<>(Arrays.asList(1,2,3,4,-1));
        System.out.println(isValidSubsequence(array,sequence));
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {

        if (array.size() < sequence.size()){
            return false;
        }
        int i = 0;
        for(Integer integer : array){
            if(i == sequence.size()){
                break;
            }
            if(i < sequence.size() && integer.equals(sequence.get(i))){
                i++;
            }
        }
        return i == sequence.size();
    }

    public static boolean isValidSubsequenceAlternative(List<Integer> array, List<Integer> sequence) {

        if(sequence.size() > array.size()){
            return false;
        }

       int seqIdx = 0 , arrayIdx = 0;
       while (seqIdx < sequence.size() && arrayIdx < array.size()){
           if (seqIdx == sequence.size()){
               break;
           }
           if (array.get(arrayIdx).equals(sequence.get(seqIdx))){
               seqIdx++;
           }
           arrayIdx++;
       }

       return seqIdx == sequence.size();
    }
}
