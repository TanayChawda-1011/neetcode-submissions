class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;

        // 0 1 3 0 4 0 4 2
        //           k
        //                 i

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val)
                nums[k++] = nums[i];
        }

        return k;
    }
}