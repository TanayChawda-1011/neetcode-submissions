class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int l = 0;
        PriorityQueue<int[]> max_heap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );

        for(int r = 0; r < nums.length; r++) {
            max_heap.offer(new int[]{nums[r], r});

            if(r - l + 1 > k) {
                l++;
            }

            if(r - l + 1 == k) {
                while(max_heap.peek()[1] < l) {
                    max_heap.poll();
                }
                list.add(max_heap.peek()[0]);
            }
        }

        int n = list.size();
        int[] res = new int[n];

        for(int i = 0; i < n; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
