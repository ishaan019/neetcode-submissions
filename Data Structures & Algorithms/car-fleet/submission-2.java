class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;

        int[][] pair = new int[N][2];//(position, speed)

        for(int i = 0; i < N; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a,b) -> Integer.compare(b[0], a[0]));

        Stack<Double> st = new Stack<>();

        for(int[] p : pair) {
            
            //time calculation
            int pos = p[0];
            int spd = p[1];

            double timeLeft = (double) (target - pos) / spd;

            if(!st.isEmpty() && timeLeft <= st.peek()) {
                continue;
            }

            st.push(timeLeft);
        }

        return st.size();        
    }
}
