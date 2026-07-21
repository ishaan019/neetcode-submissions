class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();

        for(String s: tokens) {
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {

                if(st.size() < 2) {
                    return -1;
                }

                int nums2 = Integer.parseInt(st.pop());
                int nums1 = Integer.parseInt(st.pop());

                int res = 0;
                if(s.equals("+")) {
                    res = nums1 + nums2;
                } else if(s.equals("-")){
                    res = nums1 - nums2;
                } else if(s.equals("*")){
                    res = nums1 * nums2;
                } else if(s.equals("/")){
                    res = nums1 / nums2;
                }

                st.push(String.valueOf(res));
            } else {
                st.push(s);
            }
        } 

        return Integer.valueOf(st.pop());
    }
}
