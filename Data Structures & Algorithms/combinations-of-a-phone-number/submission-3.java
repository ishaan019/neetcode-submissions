class Solution {
    List<String> res = new ArrayList<>();
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno","pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {//34

        if(digits.isEmpty()) {
            return res;
        }

        StringBuilder sb = new StringBuilder();
        dfs(0, digits.toCharArray(), sb);

        return res;
    }

    void dfs(int i, char[] digits, StringBuilder sb) {//34
        if(i == digits.length) {
            res.add(sb.toString());
            return;
        }

        String chars = map[digits[i] - '0'];//def
        for(char ch : chars.toCharArray()) {//d,e,f
            sb.append(ch);
            dfs(i + 1, digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
