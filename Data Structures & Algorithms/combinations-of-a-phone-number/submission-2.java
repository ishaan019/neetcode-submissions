class Solution {
    List<String> res = new ArrayList<>();
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {

        if(digits.isEmpty()) {
            return res;
        }

        dfs(0, "", digits);

        return res;
    }

    void dfs(int i, String curr, String digits) {
        if (i == digits.length()) {
            res.add(curr);
            return;
        }

        String chars = map[digits.charAt(i) - '0'];

        for(char c : chars.toCharArray()) {
            dfs(i + 1, curr + c, digits);
        }
    }
}
