class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        // BASE CASE 1: if tLen == 0 -> return 1;
        // dp[m][0] = 1;
        for(int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }


        // BASE CASE 2: when sLen == 0 -> return 0.
        // dp[0][n] = 1;
        // But start from i = 1. As dp[0][0] should always be 1. Think about 1.

        for(int i = 1; i <= n; i++) {
            dp[0][i] = 0;
        }


        // You've already initialized the first row and column.
        // So start from dp[1][1] instead!

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[m][n];
    }
}
