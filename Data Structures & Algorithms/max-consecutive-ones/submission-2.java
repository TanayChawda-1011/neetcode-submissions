class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int cur = 0;

        for(int n : nums) {
            if(n == 1) {
                cur += 1;
            } else {
                if(cur > res) res = cur;
                cur = 0;
            }
        }

        return Math.max(res, cur);
    }
}