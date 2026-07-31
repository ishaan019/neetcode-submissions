class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int N = hand.length;
        if (N % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : hand) {
            map.put(i, 1 + map.getOrDefault(i, 0));
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        minHeap.addAll(map.keySet());

        while (!minHeap.isEmpty()) {
            int top = minHeap.peek();

            for (int i = top; i < top + groupSize; i++) {
                if (!map.containsKey(i)) {
                    return false;
                }
                map.put(i, map.get(i) - 1);
                if (map.get(i) == 0) {
                    if(i != minHeap.peek()) {
                        return false;
                    }
                    minHeap.poll();
                }
            }
        }
        return true;
    }
}
