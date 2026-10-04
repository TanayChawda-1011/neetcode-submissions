class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int L = 0;
        int R = n - 1;
        int res = 0;

        while(L < R) {
            if(heights[L] > heights[R]) {
                res = Math.max(res, heights[R] * (R - L));
                R--;
            }
            else {
                res = Math.max(res, heights[L] * (R - L));
                L++;
            }
        }

        return res;
    }
}
