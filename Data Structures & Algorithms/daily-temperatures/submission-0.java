class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int N = arr.length;

        Stack<int[]> st = new Stack<>(); // index, val
        st.push(new int[] {N - 1, arr[N - 1]});

        int[] ans = new int[N];
        ans[N - 1] = 0;

        for (int i = N - 2; i >= 0; i--) {
            int currIdx = i;
            int currVal = arr[i];

            while (!st.isEmpty() && currVal >= st.peek()[1]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = st.peek()[0] - currIdx;
            }

            st.push(new int[] {currIdx, currVal});
        }

        return ans;
    }
}
