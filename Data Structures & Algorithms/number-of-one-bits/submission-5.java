class Solution {
    public int hammingWeight(int n) {
        int res = 0;//1
        while(n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
