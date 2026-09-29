class Solution {
    public int[] productExceptSelf(int[] nums) {

        // [1  , 2  , 4 , 6,  5]
        // [1  , 1  , 2 , 8, 48]
        // [240, 120, 30, 5,  1]
        
        // [1, 2, 8, 48, 240]

        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = 1;
        suffix[n - 1] = 1;

        for(int i = 1; i < n; i++) {
            prefix[i] = nums[i - 1] * prefix[i - 1];
        }

        for(int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for(int i = 0; i < n; i++) {
            nums[i] = prefix[i] * suffix[i];
        }

        return nums;
    }
}  
