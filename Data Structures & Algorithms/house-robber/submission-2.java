class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1)  return nums[0];
        if(n == 2)  return nums[0] > nums[1] ? nums[0] : nums[1];

        int twoPosBack = nums[0];
        int onePosBack = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++) {
            int temp = Math.max(nums[i] + twoPosBack, onePosBack);
            twoPosBack = onePosBack;
            onePosBack = temp;
        }

        return onePosBack;
    }
}
