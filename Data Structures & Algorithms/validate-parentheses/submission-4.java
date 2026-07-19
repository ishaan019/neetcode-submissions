class Solution {
    public boolean isValid(String s) {
        int N = s.length();
        Stack<Character> st = new Stack<>();

        char[] arr = s.toCharArray();

        for (int i = 0; i < N; i++) {
            if (arr[i] == '(' || arr[i] == '{' || arr[i] == '[') {
                st.push(arr[i]);
            } else {
                if (st.isEmpty()) {
                    return false;
                }

                char ch = st.pop();
                if (ch == '(' && arr[i] == ')' || ch == '{' && arr[i] == '}'
                    || ch == '[' && arr[i] == ']') {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}
