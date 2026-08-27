class DSU {
    List<Integer> rank;
    List<Integer> parent;
    List<Integer> size;
    int noOfComponents;

    DSU(int n) {
        rank = new ArrayList<>(n);
        parent = new ArrayList<>(n); 
        size = new ArrayList<>(n); 
        noOfComponents = n;

        for(int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    int find(int u) {
        if(u == parent.get(u)) {
            return u;
        }

        int ulp = find(parent.get(u));
        parent.set(u, ulp);
        return ulp;
    }

    boolean unionByRank(int u, int v) {
        int ulp_u = find(u);
        int ulp_v = find(v);

        if(ulp_u == ulp_v) {
            return false;
        }

        if(rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_u) > rank.get(ulp_v)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
        }
        noOfComponents--;

        return true;
    } 

    boolean unionBySize(int u, int v) {
        int ulp_u = find(u);
        int ulp_v = find(v);

        if(ulp_u == ulp_v) {
            return false;
        }

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
        noOfComponents--;

        return true;

    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        // for(int[] e : edges) {
        //     dsu.unionByRank(e[0], e[1]);
        // }

        for(int[] e : edges) {
            dsu.unionBySize(e[0], e[1]);
        }

        return dsu.noOfComponents;
    }
}
