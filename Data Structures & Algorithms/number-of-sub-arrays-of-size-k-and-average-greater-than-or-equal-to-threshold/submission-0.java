class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        int l = 0, curSum = 0;

        for(int r = 0; r < arr.length; r++) {
            curSum += arr[r];
            
            if(r - l + 1 == k) {
                if(curSum >= k * threshold)
                    res++;
                curSum -= arr[l];
                l++;
            }
        }

        return res;
    }
}