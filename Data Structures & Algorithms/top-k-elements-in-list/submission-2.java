class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            freq[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            freq[value].add(key);
        }

        int counter = 0;
        for (int i = nums.length; i >= 0; i--) {
            List<Integer> values = freq[i];
            for (int val : values) {
                ans[counter] = val;
                counter++;

                if (counter == k) {
                    return ans;
                }
            }
        }

        return ans;
    }
}
