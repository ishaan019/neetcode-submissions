class Solution {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length > n - 1) {
            return false;
        }

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] e : edges) {
            int u = e[0];
            int v = e[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        if(dfs(0, adjList, visited, -1) == true) {
            return false;
        }

        for(boolean b : visited) {
            if(b == false) {
                return false;
            }
        }

        return true;
    }

    boolean dfs(int i, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int parent) {
        visited[i] = true;

        for(int nbr : adjList.get(i)) {
            if(visited[nbr] == false) {
                if(dfs(nbr, adjList, visited, i) == true) {
                    return true;
                }
            } else if(nbr != parent) {
                return true;
            }
        }

        return false;
    }
}
