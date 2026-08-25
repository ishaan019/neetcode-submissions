class Pair {
    double dist;
    int idx;

    Pair(double dist, int idx) {
        this.dist = dist;
        this.idx = idx;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.dist, a.dist));

        int idx = 0;
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            double dist = Math.sqrt(Math.pow((x), 2) + Math.pow((y), 2)); // 2.8

            pq.offer(new Pair(dist, idx)); //[2,0]
            idx++;

            if (pq.size() > k) { // 2>1
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];

        int i = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int y = curr.idx;

            ans[i] = points[y];
            i++;
        }

        return ans;
    }
}
