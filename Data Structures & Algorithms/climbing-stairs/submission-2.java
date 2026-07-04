class Solution {
    public int climbStairs(int n) {
        int[] qb = new int[n + 1];
        return dp(n, qb);
    }

    private int dp(int n, int[] qb) {
        if(n == 0) {
            return 1;
        }

        if(n < 0) {
            return 0;
        }

        if(qb[n] > 0) {
            return qb[n];
        }

        int nm1 = dp(n - 1, qb);
        int nm2 = dp(n - 2, qb);
        int cp = nm1 + nm2;

        qb[n] = cp;
        return cp;
    }
}
