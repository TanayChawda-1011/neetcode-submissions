class Solution {
    public int climbStairs(int n) {
        int f0 = 1, f1 = 1;
        int f2;

        // f0 f1 f2
        // update f0 as f1
        // update f1 as f2 

        for(int i = 0; i < n; i++) {
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        }

        return f0;
    }
}
