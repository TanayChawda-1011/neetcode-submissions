class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] prev = new int[n + 1];
        int[] cur = new int[n + 1];

        prev[0] = 1;
        cur[0] = 1;


        // You've already initialized the first row and column.
        // So start from dp[1][1] instead!

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1))
                    cur[j] = prev[j - 1] + prev[j];
                else
                    cur[j] = prev[j];
            }

            int[] temp = cur;
            cur = prev;
            prev = temp;
        }

        return prev[n];
    }
}
