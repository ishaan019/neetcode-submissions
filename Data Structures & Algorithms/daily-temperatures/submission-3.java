class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int N = temperatures.length;
        int[] res = new int[N];

        Stack<int[]> st = new Stack<>(); //[temp, index]

        for (int i = 0; i < N; i++) {
            int temp = temperatures[i];

            while (!st.isEmpty() && temp > st.peek()[0]) {
                int[] top = st.pop();
                int tem = top[0];
                int idx = top[1];
                res[idx] = i - idx;
            }

            st.push(new int[] {temp, i});
        }

        return res;
    }
}
