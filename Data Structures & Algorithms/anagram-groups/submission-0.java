class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for(String str : strs) {
            int[] arr = new int[26];
            for(int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }

            String key = Arrays.toString(arr);

            if(hashMap.containsKey(key)) {
                System.out.print("Contains");
                List<String> list = hashMap.get(key);
                list.add(str);
                hashMap.put(key, list);
            } else {
                System.out.print("Not Contains");
                List<String> list = new ArrayList<>();
                list.add(str);
                hashMap.put(key, list);
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for(List<String> list : hashMap.values()) {
            ans.add(list);
        }

        return ans;
    }
}
