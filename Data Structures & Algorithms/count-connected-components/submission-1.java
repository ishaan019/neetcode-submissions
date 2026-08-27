class Solution {
    public int countComponents(int n, int[][] edges) {
        // create adjacency list from edges
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        Set<Integer> visited = new HashSet<>();

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(i, visited, adjList);
                count++;
            }
        }

        return count;
    }

    private void dfs(int src, Set<Integer> visited, Map<Integer, List<Integer>> adjList) {
        visited.add(src);

        for (int nbr : adjList.get(src)) {
            if(!visited.contains(nbr)) {
                dfs(nbr, visited, adjList);
            }
        }
    }
}
