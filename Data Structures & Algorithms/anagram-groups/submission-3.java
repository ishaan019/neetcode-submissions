class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> answer = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        //[[1,0,1....1]] : [act,cat]]
        //[[hat] : [hat]]
        //[[key] : ["stop", "pots", "tops"]]

        for (String str : strs) {
            int[] arr = new int[26];
            for (char ch : str.toCharArray()) { //[a,c,t]
                arr[ch - 'a']++; //[1,0,1,....1]
            }

            String key = Arrays.toString(arr);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                map.put(key, new ArrayList<>());
                map.get(key).add(str);
            }
        }

        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> val = entry.getValue();
            answer.add(val);
        }

        return answer;
    }
}
