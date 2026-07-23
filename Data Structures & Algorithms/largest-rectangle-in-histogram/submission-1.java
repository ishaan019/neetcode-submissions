class Solution {
    public int largestRectangleArea(int[] heights) {

        int N = heights.length;
        int[] leftSmallest = new int[N];
        int[] rightSmallest = new int[N];

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < N; i++) {
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            if(!st.isEmpty()) {
                leftSmallest[i] = st.peek();
            } else {
                leftSmallest[i] = -1;
            }
            
            st.push(i);
        }

        st.clear();

        for(int i = N - 1; i >= 0; i--) {
            rightSmallest[i] = N;

            while(!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            if(!st.isEmpty()) {
                rightSmallest[i] = st.peek();
            }
            st.push(i);
        }

        int maxArea = 0;

        for(int i = 0; i < N; i++) {
            leftSmallest[i] += 1;
            rightSmallest[i] -= 1;

            maxArea = Math.max(maxArea, heights[i] * (rightSmallest[i] - leftSmallest[i] + 1));
        }

        return maxArea;   
    }
}
