class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;

        int[] res = new int[N - k + 1];

        Deque<Integer> q = new LinkedList<>();

        int l = 0;
        int r = 0;
        int idx = 0;
        while (r < N) {
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }
            q.addLast(r);

            if (l > q.getFirst()) {
                q.removeFirst();
            }

            if ((r + 1) >= k) {
                res[l] = nums[q.getFirst()];
                l++;
            }
            r++;
        }
        return res;
    }
}
