class Solution {
    public void sortColors(int[] nums) {
        int[] freq = new int[3];

        for(int n : nums)
            freq[n]++;

        int x = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < freq[i]; j++) {
                nums[x] = i;
                x++;
            }
        }
    }
}