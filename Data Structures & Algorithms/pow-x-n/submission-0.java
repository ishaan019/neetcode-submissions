class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        while(n != 0) {
            if(n > 0) {
                res = res * x;
                n--;
            } else {
                res = res / x;
                n++;
            }
        }
        return res;
        
    }
}
