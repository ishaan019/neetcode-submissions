class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            adjList.get(u).add(new int[] {v, w}); // destination, weight
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[] {k, 0});

        Set<Integer> visited = new HashSet<>();

        int t = 0;
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int n1 = curr[0];
            int w1 = curr[1];

            if (visited.contains(n1)) {
                continue;
            }

            visited.add(n1);
            t = w1;

            // if (adjList.get(n1)) {
                for (int[] next : adjList.get(n1)) {
                    int n2 = next[0];
                    int w2 = next[1];
                    if (!visited.contains(n2)) {
                        minHeap.offer(new int[] {n2, w1 + w2});
                    }
                }
            // }
        }
        return visited.size() == n ? t : -1;
    }
}
