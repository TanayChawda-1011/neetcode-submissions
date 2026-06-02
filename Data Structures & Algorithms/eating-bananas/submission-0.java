class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for(int i = 1; i < piles.length; i++) {
            if(max < piles[i])
                max = piles[i];
        }

        int l = 1, res = max;

        while(l <= max) {
            int k = l + (max - l) / 2;
            int hours = 0;

            for(int p: piles)
                hours += Math.ceil((double) p / k);

            if(hours <= h) {
                res = k;
                max = k - 1;
            } else
                l = k + 1;
        }
        return res;
    }
}
