class Solution {
    public int lastStoneWeight(int[] stones) {

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for(int stone : stones) {
            pq.offer(stone);
        }

        while(pq.size() > 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();

            if(s1 == s2) {
                continue;
            } else {
                int val = Math.abs(s1 - s2);
                pq.offer(val);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
        
    }
}
