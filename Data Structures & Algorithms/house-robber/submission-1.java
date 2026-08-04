class Solution {
    int max;
    public int rob(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        return memoization(0, nums, memo);
    }

    public int memoization(int i, int[] nums, Integer[] memo) {
        if(i >= nums.length)   return 0;

        if(memo[i] != null) return memo[i];

        int val1 = nums[i] + memoization(i + 2, nums, memo);
        int val2 = memoization(i + 1, nums, memo);

        return memo[i] = Math.max(val1, val2);
    }
}
