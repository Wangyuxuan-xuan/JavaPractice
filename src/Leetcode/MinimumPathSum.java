package Leetcode;

import java.util.HashMap;
import java.util.Objects;

public class MinimumPathSum {

    HashMap<TwoDCache[][] , Integer> cache = new HashMap<>();
    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int[][] grid = new int[][]{{1,3,1}, {1,5,1}, {4,2,1}};

        System.out.println(minimumPathSum.minPathSum(grid));
    }
    public int minPathSum(int[][] grid) {

        int[][] memo = new int[grid.length][grid[0].length];

//        System.out.println(memo[0][1]);
//        return 0;

        return dfs(grid , 0, 0 , memo);
    }

    public int dfs(int[][] grid , int width , int height , int[][] memo){

        if (width == grid[0].length  || height == grid.length ){
            return Integer.MAX_VALUE;
        }

        if (memo[height][width] != 0){
            return memo[height][width];
        }


        if (width == grid[0].length - 1 && height == grid.length - 1){
            return grid[height][width];
        }

        int downSum =  dfs(grid , width , height + 1  , memo);
        int rightSum =  dfs(grid , width + 1 , height , memo);

        memo[height][width] = grid[height][width] + Math.min(downSum, rightSum);

        return memo[height][width];

    }

    class TwoDCache{
        int x;
        int y;

        public TwoDCache(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TwoDCache twoDCache = (TwoDCache) o;
            return x == twoDCache.x && y == twoDCache.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
