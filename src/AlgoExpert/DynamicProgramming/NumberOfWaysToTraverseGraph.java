package AlgoExpert.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class NumberOfWaysToTraverseGraph {

    int count = 0 ;

    public static void main(String[] args) {
        NumberOfWaysToTraverseGraph numberOfWaysToTraverseGraph = new NumberOfWaysToTraverseGraph();

        System.out.println(numberOfWaysToTraverseGraph.numberOfWaysToTraverseGraphDfs(3,1));
    }
    public int numberOfWaysToTraverseGraph(int width, int height) {
        // Write your code here.

        int widthFactorial = factorial(width - 1);
        int heightFactorial = factorial(height - 1);
        int totalFactorial = factorial( width + height - 2);

        return totalFactorial / (widthFactorial * heightFactorial);
    }

    public int factorial(int n){

        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public int numberOfWaysToTraverseGraphDfs(int width, int height) {
        // Write your code here.

        return dfs(width - 1 ,height - 1);
    }

    public int dfs(int width , int height){
        if (width < 0 || height < 0){
            return 0;
        }

        if (width == 0 && height == 0){
            return 1;
        }

        int right = dfs(width - 1 , height);
        int down = dfs(width , height - 1);

        return right + down;

    }

}
