class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;

        // 0 1 2 3 4 5 6
        // 2 3 4 3 4
        //       k
        //           i


        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val)
                nums[k++] = nums[i];
        }
        return k;
    }
}