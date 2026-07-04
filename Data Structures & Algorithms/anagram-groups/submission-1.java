class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for(String str : strs) {
            int[] arr = new int[26];
            for(int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }

            String key = Arrays.toString(arr);

            if(!hashMap.containsKey(key)) {
                hashMap.put(key, new ArrayList<>());
            }
            hashMap.get(key).add(str);
        }

        return new ArrayList<>(hashMap.values());
        // List<List<String>> ans = new ArrayList<>();

        // for(List<String> list : hashMap.values()) {
        //     ans.add(list);
        // }

        // return ans;
    }
}
