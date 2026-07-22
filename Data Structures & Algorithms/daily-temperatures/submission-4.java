class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int N = temperatures.length;
        int[] res = new int[N];

        Stack<Integer> st = new Stack<>(); //[index]

        for (int i = 0; i < N; i++) {
            int temp = temperatures[i];

            while (!st.isEmpty() && temp > temperatures[st.peek()]) {
                int idx = st.pop();
                res[idx] = i - idx;
            }

            st.push(i);
        }

        return res;
    }
}
