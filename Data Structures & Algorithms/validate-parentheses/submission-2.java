class Solution {
    public boolean isValid(String s) {
        int N = s.length();
        Stack<Character> st = new Stack<>();
        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')','(');
        closeToOpen.put('}','{');
        closeToOpen.put(']','[');

        char[] arr = s.toCharArray();

        for(char c : arr) {
            if(closeToOpen.containsKey(c)) {
                if(!st.isEmpty() && st.peek() == closeToOpen.get(c)) {
                    st.pop();
                } else {
                    return false;
                }
            } else{
                st.push(c);
            }
        }
        return st.isEmpty();
    }
}
