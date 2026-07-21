class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int N = arr.length;

        Stack<Integer> st = new Stack<>(); // index
        // st.push(N - 1);

        int[] ans = new int[N];
        // ans[N - 1] = 0;

        for (int i = N - 1; i >= 0; i--) {
            int currIdx = i;
            int currVal = arr[i];

            while (!st.isEmpty() && currVal >= arr[st.peek()]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = st.peek() - currIdx;
            }

            st.push(currIdx);
        }

        return ans;
    }
}
