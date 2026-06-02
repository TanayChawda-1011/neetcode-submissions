class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = piles[0], res, k, totalHours;

        for(int p: piles) {
            if(r < p)
                r = p;
        }
        
        res = r;

        while(l <= r) {
            k = l + (r - l) / 2;
            totalHours = 0;

            for(int p: piles)
                totalHours += Math.ceil((double)p / k);
            
            if(totalHours <= h) {
                res = k;
                r = k - 1;
            } else
                l = k + 1;
        }

        return res;
    }
}
