class Solution {
    public boolean checkValidString(String s) {
        int open = 0;
        return dfs(s, open, 0);
    }

    boolean dfs(String s, int openParanthesis, int i) {
        if(openParanthesis < 0) {
            return false;
        }

        if (i == s.length()) {
            return openParanthesis == 0;
        }

        char ch = s.charAt(i);
        if (ch == '(') {
            return dfs(s, openParanthesis + 1, i + 1);
        } else if (ch == '*') {
            // 3 calls
            return dfs(s, openParanthesis - 1, i + 1) || dfs(s, openParanthesis, i + 1)
                || dfs(s, openParanthesis + 1, i + 1);
        } else {
            return dfs(s, openParanthesis - 1, i + 1);
        }
    }
}
