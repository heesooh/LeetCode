class Solution {
    // Brute Force
    // Time: O(2^n)
    // Space: O(n) depth of the tree can grow up to "n" (i.e., all 1s)
    public int climbStairs_BruteForce(int n) {
        return clibStairsHelper_BruteForce(0, n);
    }

    private int clibStairsHelper_BruteForce(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return clibStairsHelper_BruteForce(i+1, n) + clibStairsHelper_BruteForce(i+2, n);
    }

    // Recursion with Memoization
    // Time: O(n)
    // Space: O(n)
    public int climbStairs_Memoization(int n) {
        int[] memo = new int[n+1];
        return climbStairsHelper_Memoization(0, n, memo);
    }

    private int climbStairsHelper_Memoization(int i, int n, int[] memo) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climbStairsHelper_Memoization(i+1, n, memo) + climbStairsHelper_Memoization(i+2, n, memo);

        return memo[i];
    }

    // Dynamic Programming
    // Time: O(n)
    // Space: O(n)
    public int climbStairs_DynamicProgramming(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}