class Solution {
    public int removeDuplicates(int[] nums) {
        int counter = 1;
        int l = 1;
        int r = 1;
        int n = nums.length;

        // 0  1  2  3  4  5  6  7  8
        // 0, 0, 1, 1, 1, 1, 2, 3, 3
        // 0, 0, 1, 1, 2, 3, 3, 3, 3
        //                      l
        //                           r
        // counter = 1

        while(r < n) {
            if(nums[r] != nums[r - 1]) {
                counter = 1;
                nums[l++] = nums[r];
            } else {
                if(counter != 2) {
                    nums[l++] = nums[r];
                    counter++;
                }
            }

            r++;
        }

        return l;
    }
}