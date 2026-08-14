class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, curSum = 0;
        int length = Integer.MAX_VALUE;

        for(int r = 0; r < nums.length; r++) {
            curSum += nums[r];

            while(curSum >= target) {
                length = Math.min(length, r - l + 1);
                curSum -= nums[l];
                l++;
            }
        }

        if(length == Integer.MAX_VALUE)
            return 0;

        return length;
    }
}