class Solution {
    public int maxProductDifference(int[] nums) {
        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;

        for(int n : nums) {
            if(n >= firstMax) {
                secondMax = firstMax;
                firstMax = n;
            } else if(n >= secondMax)
                secondMax = n;

            if(firstMin >= n) {
                secondMin = firstMin;
                firstMin = n;
            } else if(secondMin >= n)
                secondMin = n;
        }

        return (firstMax * secondMax) - (firstMin * secondMin);
    }
}