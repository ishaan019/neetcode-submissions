class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // dijkatra's algorithm

        // create adjList and fill

        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for(int i = 0; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        // [[1,2,1],[2,3,1],[1,4,4],[3,4,1]]
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            adjList.get(u).add(new int[] {v, w}); // node, weight
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); //[node, weight]
        Set<Integer> visited = new HashSet<>();

        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;

        pq.offer(new int[] {k, 0}); 

        int maxTime = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int weight = curr[1];

            if(visited.contains(node)) {
                continue;
            }

            visited.add(node);
            maxTime = Math.max(maxTime, weight);

            for (int[] nbr : adjList.get(node)) {
                int nextNode = nbr[0];
                int w = nbr[1];

                int totalWeight = weight + w;

                if (totalWeight < distances[nextNode]) {
                    distances[nextNode] = totalWeight;
                    pq.offer(new int[] {nextNode, totalWeight});
                }
            }
        }

        if (visited.size() == n) {
            return maxTime;
        } else {
            return -1;
        }

        // put starting kth node into queue and visited set

        // while(!q.isEmpty()) {

        // perform actions
        // }
    }
}
