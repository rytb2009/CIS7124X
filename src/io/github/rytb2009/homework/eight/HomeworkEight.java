package io.github.rytb2009.homework.eight;


import java.util.Arrays;

public class HomeworkEight {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(coinChange(coins, 5));
        int[][] path = {{31, 100, 65, 12, 18},
                        {10, 13, 47, 157, 6},
                        {100, 113, 174, 11, 33},
                        {88, 124, 41, 20, 140,},
                        {99, 32, 111, 41, 20}};
        System.out.println(minPathSum(path));
        System.out.println(cutSegments(5, 3, 4, 5));
    }

    public static int cutSegments(int length, int x, int y, int z) {
        int dp[] = new int[length + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i <= length; i++) {
            if (dp[i] == -1) {
                continue;
            }
            if (i + x <= length) {
                dp[i + x] = Math.max(dp[i + x], dp[i] + 1);
            }
            if (i + y <= length) {
                dp[i + y] = Math.max(dp[i + y], dp[i] + 1);
            }
            if (i + z <= length) {
                dp[i + z] = Math.max(dp[i + z], dp[i] + 1);
            }
        }
        return dp[length];
    }

    // only able to solve this problem via DP if down/right move is allowed.
    public static int minPathSum(int[][] grid) {
        int[][] solution = new int[grid.length][grid.length];

        solution[0][0] = grid[0][0];
        // fill the first row
        for (int i = 1; i < grid.length; i++) {
            solution[0][i] = grid[0][i] + solution[0][i - 1];
        }

        // fill the first column
        for (int i = 1; i < grid.length; i++) {
            solution[i][0] = grid[i][0] + solution[i - 1][0];
        }

        // path will be either from top or left, choose which ever is minimum
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid.length; j++) {
                solution[i][j] = grid[i][j] + Math.min(solution[i - 1][j], solution[i][j - 1]);
            }
        }
        return solution[grid.length - 1][grid.length - 1];
    }


    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // Pick all coins one by one and update dp[] values after the index greater than or equal to the value of the picked coin
        for (int coin: coins) {
            for (int i = coin; i < amount + 1; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[amount];
    }
}
