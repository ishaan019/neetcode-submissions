class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] arr = new int[26];

        for(int i = 0; i < s.length(); i++) {
            char s_ch = s.charAt(i);
            arr[s_ch - 'a']++;

            char t_ch = t.charAt(i);
            arr[t_ch - 'a']--;
        }


        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
