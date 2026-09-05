class Solution {
    //[Hello, World]
    public String encode(List<String> strs) {
        // lv encoding krdte hain
        StringBuilder encodedString = new StringBuilder();
        for (String s : strs) {
            int len = s.length();
            encodedString.append(len).append("#").append(s);
        }

        System.out.println(encodedString.toString());

        return encodedString.toString();
    }
    // 0123456789
    // 5#Hello5#World
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int N = str.length();

        int i = 0;
        while (i < N) {//0
            int j = i;//1

            while (str.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j));//5

            String subStr = str.substring(j + 1, j + 1 + len);
            res.add(subStr);

            i = j + 1 + len;
        }

        return res;
    }
}
