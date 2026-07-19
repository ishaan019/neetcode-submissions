class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // find length of s1 = l1
        // count frequencty of s1
        // take a window of size of l1 and count frequency
        // if both frequencies are same, return true
        // but if not found return false

        int l1 = s1.length();
        int l2 = s2.length();

        if (l1 > l2) {
            return false;
        }

        int[] arr1 = new int[26]; // to store frequency of s1
        int[] arr2 = new int[26]; // to store frequency of s2

        for (int i = 0; i < l1; i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        if(matches(arr1, arr2)) {
            return true;
        }

        int l = 0;
        for (int r = l1; r < l2; r++) {
            arr2[s2.charAt(r) - 'a']++;
            arr2[s2.charAt(l) - 'a']--;
            l++;

            if(matches(arr1, arr2)) {
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
