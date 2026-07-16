class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int n : stones)
            pq.offer(n);

        while(pq.size() >= 2) {
            int a = pq.poll();
            int b = pq.poll();
            if(a != b)
                pq.offer(a - b);
        }
        
        return pq.size() > 0 ? pq.poll() : 0;
    }
}
