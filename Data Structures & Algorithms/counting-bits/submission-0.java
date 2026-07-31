class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;

        for(int i = 1; i <= n; i++) {
            res[i] = countOneBits(i);
        }

        return res;
    }

    public int countOneBits(int n) {
        int count = 0;

        while(n > 0) {
            if((n & 1) == 1)    count++;
            n >>= 1;
        }

        return count;
    }
}
