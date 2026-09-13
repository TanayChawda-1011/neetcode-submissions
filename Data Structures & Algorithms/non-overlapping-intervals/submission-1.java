class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 1)   return 0;
        
        int minRemovals = 0;
        
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] != b[0])    return a[0] - b[0];
            return a[1] - b[1];
        });

        int prevEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(start < prevEnd) {
                minRemovals++;
                prevEnd = Math.min(prevEnd, end);
            } else {
                prevEnd = end;
            }
        }

        return minRemovals;
    }
}
