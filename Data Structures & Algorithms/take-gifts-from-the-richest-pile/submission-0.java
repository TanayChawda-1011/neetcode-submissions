class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int gift : gifts)
            pq.offer(gift);

        while(k-- > 0) {
            int val = pq.poll();
            pq.offer((int)Math.sqrt(val));
        }

        long res = 0;

        while(!pq.isEmpty())
            res += pq.poll();

        return res;
    }
}