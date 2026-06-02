class Solution {
    public int removeDuplicates(int[] nums) {
        int k  = 0; 

        // 0 1 2 3 4
        // 1 2 3 4 4
        //           i
        //       k

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[k])
                nums[++k] = nums[i];
        }

        return k + 1;
    }
}