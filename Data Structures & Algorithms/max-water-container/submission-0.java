class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int max = 0;

        while(l < r) {
            if(heights[l] <= heights[r]) {
                int curMax = heights[l] * (r - l);
                max = max >= curMax ? max : curMax;
                l++;
            } else {
                int curMax = heights[r] * (r - l);
                max = max >= curMax ? max : curMax;
                r--;
            }
        }

        return max;
    }
}
