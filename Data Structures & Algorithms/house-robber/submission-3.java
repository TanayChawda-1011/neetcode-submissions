class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1)  return nums[0];
        if(n == 2)  return nums[0] > nums[1] ? nums[0] : nums[1];

        int prev = 0;
        int cur = 0;

        for(int i : nums) {
            int temp = Math.max(i + prev, cur);
            prev = cur;
            cur = temp;
        }

        return cur;
    }
}
