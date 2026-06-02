class Solution {
    public int[] replaceElements(int[] nums) {
        int curMax = nums[nums.length - 1];
        int rightVal = -1;

        // 0 1 2 3 4 5 
        // 5 5 3 2 2 2
        // 2 4 5 3 1 2
        // curMax = 5, rightVal = 2, i = 0;

        for(int i = nums.length - 2; i >=0; i--) {
            curMax = Math.max(curMax, rightVal);
            rightVal = nums[i];
            nums[i] = curMax;
        }

        nums[nums.length - 1] = -1;
        return nums;
    }
}