class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cur = 0;
        int res = 0;
        
        for(int n : nums) {
            if(n == 1) {
                cur++;
                res = Math.max(res, cur);
            } else 
                cur = 0;
        }

        return res;
    }
}