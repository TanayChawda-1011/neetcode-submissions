class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();

        while(n != 1) {
            n = sumOfSquares(n);
            if(!visited.add(n))
                return false;
        }

        return true;
    }

    public int sumOfSquares(int n) {
        int res =  0;

        while(n > 0) {
            int d = n % 10;
            res += d * d;
            n /= 10;
        }

        return res;
    }
}
