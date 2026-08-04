class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        Integer[] memo = new Integer[n];

        int diff = dfs(stoneValue, 0, memo);

        if(diff > 0)    return "Alice";
        if(diff < 0)    return "Bob";
        return "Tie";
    }

    public int dfs(int[] stoneValue, int i, Integer[] memo) {
        if(i >= stoneValue.length)  return 0;

        if(memo[i] != null)     return memo[i];

        int best = Integer.MIN_VALUE;
        int sum = 0;

        for(int j = i; j < Math.min(i + 3, stoneValue.length); j++) {
            sum += stoneValue[j];
            best = Math.max(best, sum - dfs(stoneValue, j + 1, memo));
        }

        memo[i] = best;
        return best;
    }
}