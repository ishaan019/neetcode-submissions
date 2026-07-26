class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];

        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[1], a[1]));//{index, dist}

        double index = 0.0;
        for(int[] point : points) {
            int x = point[0];
            int y = point[1];

            //apply eucledian
            double dist = Math.pow(x,2) + Math.pow(y,2);//2

            pq.offer(new double[] {index++, dist});//(0,2), (1,2)
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int i = 0;
        while(!pq.isEmpty()) {
            double[] curr = pq.poll();
            int idx = (int) curr[0];

            res[i++] = points[idx];
        }

        return res;
    }
}
