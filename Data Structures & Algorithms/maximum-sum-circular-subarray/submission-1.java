class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int globMax = nums[0], globMin = nums[0];
        int curMax = 0, curMin = 0, total = 0;

        for(int n : nums) {
            curMax = Math.max(curMax, 0) + n;
            curMin = Math.min(curMin + n, n);
            globMax = Math.max(globMax, curMax);
            globMin = Math.min(globMin, curMin);
            total += n;
        }

        return globMax < 0 ? globMax : Math.max(globMax, total - globMin);
    }
}