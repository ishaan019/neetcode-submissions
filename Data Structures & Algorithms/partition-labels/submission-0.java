class Solution {
    public List<Integer> partitionLabels(String s) {
        int N = s.length();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }

        int l = 0;
        int r = 0;

        List<Integer> res = new ArrayList<>();
        while (r < N) {
            int size = 0;
            while (l <= r) {
                char ch = s.charAt(l);
                int lastIndexOfVal = map.get(ch);

                if(lastIndexOfVal > r) {
                    r = lastIndexOfVal;
                }

                size++;
                l++;
            }
            r = l;
            res.add(size);
        }
        return res;
    }
}
