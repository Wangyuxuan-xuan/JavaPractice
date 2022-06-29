package AlgoExpert.DynamicProgramming;

import java.util.HashMap;

public class NumberOfWaysToMakeChange {

    //todo
    // will in function change i this global variable ??
    int a;

    public static void main(String[] args) {
        int n = 6;
        int[] denoms = new int[]{1,5};
        System.out.println(numberOfWaysToMakeChange(n,denoms));
    }

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.

        HashMap<Integer , Integer> cache = new HashMap<>();
        return dfs(0,n,denoms , cache);

    }

    /**
     * time complexity o*n
     * @param i
     * @param currentRemainingCoin
     * @param denoms
     * @return
     */
    static int dfs(int i, int currentRemainingCoin , int[] denoms ,HashMap<Integer , Integer> cache ){

        //todo how to cache ?
        //currently the caching will produce repeat results that the "i" trick eliminated
        if (cache.containsKey(currentRemainingCoin)){
            return cache.get(currentRemainingCoin);
        }
        if (currentRemainingCoin < 0 ){
            return 0;
        }else if(currentRemainingCoin == 0){
            return 1;
        }
        //declare the var here will not affect other branch in decision tree
        int sum = 0;

        //j starts from i , when we do not want the equivalent path(same combinations)
        for (int j = i; j < denoms.length; j++) {
            //make calculation in parameter if u do not want them to effect each other !
            sum += dfs( j ,currentRemainingCoin - denoms[j] , denoms , cache);
        }
        cache.put(currentRemainingCoin , sum);
        return sum;
    }
}
