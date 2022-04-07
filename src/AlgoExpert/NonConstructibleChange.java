package AlgoExpert;

import java.util.Arrays;

public class NonConstructibleChange {

    public static void main(String[] args) {

    }

    public int nonConstructibleChange(int[] coins) {

        Arrays.sort(coins);
        int currentChangeReached = 0;
        for (int coin : coins){
            if(coin > currentChangeReached + 1){
                return currentChangeReached + 1;
            }
            currentChangeReached += coin;
        }
        return currentChangeReached + 1;
    }

}
