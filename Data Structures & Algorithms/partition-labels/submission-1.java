class Solution {
    public List<Integer> partitionLabels(String s) {
        int N = s.length();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }

        int l = 0;
        int end = 0;
        int size = 0;

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            size++;
            end = Math.max(end, map.get(s.charAt(i)));

            if (i == end) {
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}
