class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        int N = tickets.size();

        Map<String, PriorityQueue<String>> adjList = new HashMap<>();

        for (List<String> t : tickets) {
            String src = t.get(0);
            String dest = t.get(1);

            adjList.computeIfAbsent(src, k -> new PriorityQueue<>()).offer(dest);
        }

        List<String> res = new ArrayList<>();
        
        dfs(adjList, "JFK", res);

        Collections.reverse(res);
        
        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> adjList, String src, List<String> res) {
        PriorityQueue<String> queue = adjList.get(src);
        while(queue != null && !queue.isEmpty()) {
            String dst = queue.poll();
            dfs(adjList, dst, res);
        }
        res.add(src);
    }
}
