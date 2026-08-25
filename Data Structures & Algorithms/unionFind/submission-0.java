class UnionFind {

    List<Integer> rank;
    List<Integer> parent;
    int numberOfComponents;

    public UnionFind(int n) {
        rank = new ArrayList<>();
        parent = new ArrayList<>();
        numberOfComponents = n;

        for(int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
        }

    }

    public int find(int x) {
        if(x == parent.get(x)) {
            return x;
        }

        int ulp = find(parent.get(x));
        parent.set(x, ulp);
        return parent.get(x);
    }

    public boolean isSameComponent(int u, int v) {
        int ulp_u = find(u);
        int ulp_v = find(v);

        if(ulp_u == ulp_v) {
            return true;
        }
        return false;
    }

    public boolean union(int u, int v) {
        int ulp_u = find(u);
        int ulp_v = find(v);

        if(ulp_u == ulp_v) {
            return false;
        }

        if(rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if(rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
        numberOfComponents--;
        return true;
    }

    public int getNumComponents() {
        return numberOfComponents;
    }
}
