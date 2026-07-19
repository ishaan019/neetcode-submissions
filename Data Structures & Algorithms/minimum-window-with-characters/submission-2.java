class Solution {
    public String minWindow(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();

        int[] arr1 = new int[128];
        int[] arr2 = new int[128];

        if (l2 > l1) {
            return "";
        }

        for (int i = 0; i < l2; i++) {
            arr2[t.charAt(i)]++;
        }

        int l = 0;
        int r = 0;
        int have = 0;
        // int need = l2;
        int need = 0;
        for (int x : arr2) {
            if (x > 0)
                need++;
        }
        int minLength = Integer.MAX_VALUE;
        int i = -1;
        int j = -1;

        while (r < l1) {
            char c = s.charAt(r);
            arr1[s.charAt(r)]++;

            if (arr2[s.charAt(r)] > 0 && arr2[s.charAt(r)] == arr1[s.charAt(r)]) {
                have = have + 1;
            }

            while (have == need) {
                if ((r - l + 1) < minLength) {
                    minLength = r - l + 1;
                    i = l;
                    j = r;
                }

                char leftChar = s.charAt(l);
                arr1[leftChar]--;

                if (arr2[leftChar] > 0 && arr1[leftChar] < arr2[leftChar]) {
                    have--;
                }
                l++;
            }
            r++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(i, j + 1);
    }
}
