class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i : stones) {
            pq.offer(i);
        }

        while (!pq.isEmpty()) {
            if (pq.size() == 1) {
                return pq.peek();
            }
            int num1 = pq.poll(); // 4
            int num2 = pq.poll(); // 1
            int diff = num1 - num2;
            pq.offer(diff); // 3
        }

        return -1;
    }
}
