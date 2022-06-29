package AlgoExpert.DynamicProgramming;

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

        return dfs(0,n,denoms);

    }

    /**
     * time complexity o*n
     * @param i
     * @param currentRemainingCoin
     * @param denoms
     * @return
     */
    static int dfs(int i, int currentRemainingCoin , int[] denoms  ){

        if (currentRemainingCoin < 0 ){
            return 0;
        }else if(currentRemainingCoin == 0){
            return 1;
        }
        //declear the var here will not affect other branch in decision tree
        int sum = 0;

        //j starts from i , when we don not want the equivalent path(same combinations)
        for (int j = i; j < denoms.length; j++) {
//            currentRemainingCoin -= demon;
            //make calculation in parameter if u dont't want them to effect each other !
            sum += dfs( j ,currentRemainingCoin - denoms[j] , denoms );
        }
        return sum;
    }
}
