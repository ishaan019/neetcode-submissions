class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // create adj list
        // i need to detect a cyckle in each component of graph and should return that nodes.

        List<List<Integer>> adjList = new ArrayList<>();
        int n = edges.length;
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);

            boolean[] visited = new boolean[n + 1]; //[0,1,2,3,4]

            if (dfs(u, visited, adjList, -1)) {
                return e;
            }
        }

        return new int[0];
    }

    boolean dfs(int i, boolean[] visited, List<List<Integer>> adjList, int parent) {
        visited[i] = true;

        for (int nbr : adjList.get(i)) {
            if (visited[nbr] == false) {
                if (dfs(nbr, visited, adjList, i)) {
                    return true;
                }
            }

            else if (nbr != parent) {
                return true;
            }
        }
        return false;
    }
}
