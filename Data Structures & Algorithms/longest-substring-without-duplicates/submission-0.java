class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;

        int maxLength = 0;

        char[] arr = s.toCharArray();

        Set<Character> set = new HashSet<>();

        while(r < s.length()) {
            int currLength = 0; 
            while(set.contains(arr[r])) {
                set.remove(arr[l]);
                l++;
            }

            if(set.contains(arr[r]) == false) {
                set.add(arr[r]);
                currLength = r - l + 1;
                maxLength = Math.max(currLength, maxLength);
                r++;
            }
        }
        return maxLength;
    }
}
