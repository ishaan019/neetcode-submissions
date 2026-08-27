class Solution {
    public boolean validTree(int n, int[][] edges) {
        int edgesLength = edges.length;

        if(edgesLength != n - 1) {
            return false;
        }

        //create adjacency list from edges
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int[] e: edges) {
            int u = e[0];
            int v = e[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        //cycle detection

        Queue<int[]> q = new LinkedList<>();//node, parent
        Set<Integer> visited = new HashSet<>();
        q.offer(new int[] {0, -1});
        visited.add(0);

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];//2
            int parent = curr[1];//1

            for(int nbr : adjList.get(node)) {
                //cycle existes
                if(visited.contains(nbr) && nbr != parent) {
                    return false;
                }

                if(!visited.contains(nbr)) {
                    visited.add(nbr);
                    q.offer(new int[] {nbr, node});
                }
            }
        }

        if(visited.size() != n) {
            return false;
        }

        return true;


    }
}
