class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        HashMap<Integer, List<int[]>> adjList = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int[] time : times) {
            int u = time[0];
            int v = time[1];
            int t = time[2];

            adjList.get(u).add(new int[] {v, t});//v,time
        }

        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));//node, maxTime to reach
        Set<Integer> visited = new HashSet<>();

        pq.offer(new int[] {k, 0});//[1,0]
    
        int maxTime = 0;
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int weight = curr[1];

            // if(visited.contains(node)) {
            //     continue;
            // }

            // maxTime = Math.max(maxTime, weight);

            visited.add(node);//1

            //find the nbrs of node
            for(int[] nbr : adjList.get(node)) {
                int nextNode = nbr[0];
                int distanceToTravel = nbr[1];

                int totalDistance = weight + distanceToTravel;
                if(totalDistance < distances[nextNode]) {
                    distances[nextNode] = totalDistance;
                    pq.offer(new int[] {nextNode, totalDistance});
                }
            }
        }

        for(int a : distances) {
            if(a == Integer.MAX_VALUE) {
                a = 0;
            }
            maxTime = Math.max(a, maxTime);
        }
 
        return (visited.size() == n) ? maxTime : -1;
    }
}
