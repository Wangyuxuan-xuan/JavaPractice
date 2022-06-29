package AlgoExpert.DynamicProgramming;

import java.util.HashMap;

public class MinNumberOfCoinsForChange {

    public static void main(String[] args) {
        System.out.println(minNumberOfCoinsForChange(7 , new int[]{2,4}));
    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.

        HashMap<Integer,Integer> cache = new HashMap<>();

        int result = dfs(n,denoms , cache);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    static int dfs(int currentNumber, int[] denoms , HashMap<Integer,Integer> cache){


        //Caching , Memoization !!
        if (cache.containsKey(currentNumber)){
            return cache.get(currentNumber);
        }

        if(currentNumber < 0){
            return Integer.MAX_VALUE;
        }else if(currentNumber == 0){
            return 0;
        }

        int numOfChange = Integer.MAX_VALUE;
        for (int denom : denoms) {

            numOfChange = Math.min(numOfChange, dfs(currentNumber - denom, denoms , cache));
        }
        int newNumberOfChange = numOfChange == Integer.MAX_VALUE ? Integer.MAX_VALUE : numOfChange + 1;
        cache.put(currentNumber,newNumberOfChange);
        return newNumberOfChange;
    }
}
