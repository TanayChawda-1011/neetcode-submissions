class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        int n0 = 1, n1 = 2;

        for(int i = 2; i < n; i++) {
            int n3 = n0 + n1;
            n0 = n1;
            n1 = n3;
        }

        return n1;
    }
}
