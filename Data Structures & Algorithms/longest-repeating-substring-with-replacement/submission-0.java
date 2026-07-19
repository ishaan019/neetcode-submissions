class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int maxFreq = 0;
        int maxLength = 0;

        int[] arr = new int[26];

        while (r < s.length()) {
            arr[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, arr[s.charAt(r) - 'A']);

            while ((r - l + 1) - maxFreq > k) {
                arr[s.charAt(l) - 'A']--;
                l++;
                maxFreq = 0;
                for (int i = 0; i < 26; i++) {
                    maxFreq = Math.max(maxFreq, arr[i]);
                }
            }

            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        return maxLength;
    }
}
