class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        Integer[][] dp = new Integer[m + 1][ n + 1];
        
        return recursion(text1, text2, m, n, dp);
    }

    public int recursion(String t1, String t2, int m, int n, Integer[][] dp) {
        if(m == 0 || n == 0)
            return 0;

        if(dp[m][n] != null)
            return dp[m][n];

        if(t1.charAt(m - 1) == t2.charAt(n - 1)) {
            return dp[m][n] = 1 + recursion(t1, t2, m - 1, n - 1, dp);
        }

        return dp[m][n] = Math.max(recursion(t1, t2, m - 1, n, dp), 
                                   recursion(t1, t2, m, n - 1, dp));
    }
}
