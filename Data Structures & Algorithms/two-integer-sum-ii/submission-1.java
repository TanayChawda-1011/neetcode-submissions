class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, h = nums.length - 1;

        while(l < h) {
            if(nums[l] + nums[h] > target)
                h--;
            else if(nums[l] + nums[h] < target)
                l++;
            else
                return new int[]{l + 1, h + 1};
        }

        return new int[0];
    }
}
