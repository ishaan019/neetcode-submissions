class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();//arr[], list of strings

        for(String s : strs) {
            int[] arr = new int[26];

            for(char ch : s.toCharArray()) {
                arr[ch - 'a']++;
            }

            String key = Arrays.toString(arr);

            if(map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                map.put(key, new ArrayList<>());
                map.get(key).add(s);
            }
        }

        // key1 -> act, cat
        //key 2 -> hat

        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> val = entry.getValue();
            result.add(val);
        }

        return result;


    }
}
