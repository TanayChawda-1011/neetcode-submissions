class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // int[] dp = new int[2];
        // dp[0] = cost[cost.length - 1];
        // dp[1] = cost[cost.length - 2];
        
        for(int i = cost.length - 3; i >= 0; i--) {
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        }

        return Math.min(cost[0], cost[1]);
    }
}
