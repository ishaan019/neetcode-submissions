class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[n]; //[0,1,2,3,4]
        int comp = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                dfs(i, visited, adjList);
                comp++;
            }
        }

        return comp;
    }

    private void dfs(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adjList) {
        visited[i] = true;

        for (int nbr : adjList.get(i)) {
            if (visited[nbr] == false) {
                dfs(nbr, visited, adjList);
            }
        }
    }
}
