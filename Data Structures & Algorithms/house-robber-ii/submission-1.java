class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1)  return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int includeFirst = dp(nums, 0, n - 2);
        int excludeFirst = dp(nums, 1, n - 1);

        return Math.max(includeFirst, excludeFirst);
    }

    public int dp(int[] nums, int start, int end) {
        int prev = 0;
        int cur = 0;

        for(int i = start; i <= end; i++) {
            int temp = Math.max(nums[i] + prev, cur);
            prev = cur;
            cur = temp;
        }

        return cur;
    }
}
