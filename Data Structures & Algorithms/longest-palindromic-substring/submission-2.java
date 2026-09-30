class Solution {
    public String longestPalindrome(String s) {

        int N = s.length();
        int resLength = 0;
        String res = "";

        for(int i = 0; i < N; i++) {
            
            //Odd length
            int l = i;
            int r = i;
            while(l >= 0 && r < N && s.charAt(l) == s.charAt(r)) {
                if(r - l + 1 > resLength) {
                    res = s.substring(l, r + 1);
                    resLength = r - l + 1;
                }
                l--;
                r++;
            }

            //Even length
            l = i;
            r = i + 1;
            while(l >= 0 && r < N && s.charAt(l) == s.charAt(r)) {
                if(r - l + 1 > resLength) {
                    res = s.substring(l, r + 1);
                    resLength = r - l + 1;
                }

                l--;
                r++;
            }
        }

        return res;
    }
}
