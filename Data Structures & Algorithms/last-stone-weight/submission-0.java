class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int n : stones)
            pq.offer(n);

        int x = 0, y = 0, res;
        while(pq.size() > 1) {
            x = pq.poll();
            y = pq.poll();
            res = x == y ? 0 : Math.abs(x - y);
            pq.offer(res);
        }
        return pq.peek();
    }
}
