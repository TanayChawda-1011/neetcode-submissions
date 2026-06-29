class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Integer.MIN_VALUE;

        for(int p : piles) {
            r = Math.max(r, p);
        }

        int res = r;

        while(l <= r) {
            int hours = 0;
            int k = l + (r - l) / 2;

            for(int p : piles) {
                hours += Math.ceil((double) p / k);
                if(hours > h)
                    break;
            }

            if(hours <= h) {
                res = Math.min(res, k);
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return res;
    }
}
