class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;

        // 0  1    2   3   4   5
        // 2, 10, 30, 30, 30, 30
        //        k
        //                       i


        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[k])
                nums[++k] = nums[i];
        }

        return k + 1;
    }
}