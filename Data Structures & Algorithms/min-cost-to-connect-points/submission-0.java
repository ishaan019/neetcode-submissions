class DSU {
    List<Integer> rank;
    List<Integer> parent;

    public DSU(int n) {
        rank = new ArrayList<>();
        parent = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int find(int node) {
        if(parent.get(node) != node) {
            int ulp = find(parent.get(node));
            parent.set(node, ulp);
        }
        return parent.get(node);
    }


    public boolean union(int u, int v) {
        //find ultimate parents of both, if both are same return false;
        //then find rank of ultimate parents, according to rank set child parent relationship and return true;

        int ulp_u = find(u);
        int ulp_v = find(v);

        if(ulp_u == ulp_v) {
            return false;//already attached in same componant
        }

        int rank_u = rank.get(ulp_u);
        int rank_v = rank.get(ulp_v);

        if(rank_u < rank_v) {
            parent.set(ulp_u, ulp_v);
        } else if (rank_v < rank_u) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            rank.set(rank_u, rank_u + 1);
        }
        return true;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DSU dsu = new DSU(n);

        List<int[]> edges = new ArrayList<>();//weight, u, v

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) +
                           Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[] {dist, i, j});
            }
        }

        edges.sort((a,b) -> a[0] - b[0]);
        int res = 0;
        int edgesUsed = 0;

        for(int[] edge : edges) {
            int cost = edge[0];
            int u = edge[1];
            int v = edge[2];

            if(dsu.union(u, v)) {
                res += cost;
                edgesUsed++;

                if(edgesUsed == n - 1) {
                    break;
                }
            }
        }

        return res;
    }
}
