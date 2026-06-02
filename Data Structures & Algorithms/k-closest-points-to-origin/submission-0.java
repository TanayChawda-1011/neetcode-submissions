class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[][] res = new int[k][2];

        int idx = 0, x = 0, y = 0;
        for(int i = 0; i < points.length; i++) {
            x = points[i][0]; y = points[i][1];
            heap.offer(new int[] {x*x + y*y, i});
        }

        for(int i = 0; i < k; i++) {
            res[i] = points[heap.poll()[1]];
        }

        return res;
    }
}
