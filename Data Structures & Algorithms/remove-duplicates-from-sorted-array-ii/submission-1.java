class Solution {
    public int removeDuplicates(int[] nums) {
        int write = 2;
        int n = nums.length;

        // 0  1  2  3  4  5  6  7  8
        // 0, 0, 1, 1, 1, 1, 2, 3, 3
        // 0, 0, 1, 1, 2, 3, 3, 3, 3
        //                      w        
        //                           i
        // write = 2

        for(int i = 2; i < n; i++) {
            if(nums[write - 2] != nums[i]) {
                nums[write++] = nums[i];
            }
        }

        return write;
    }
}