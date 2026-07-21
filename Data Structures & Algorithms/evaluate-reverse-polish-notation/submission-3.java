class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String s: tokens) {
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {

                // if(st.size() < 2) {
                //     return -1;
                // }

                int nums2 = st.pop();
                int nums1 = st.pop();

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

                st.push(res);
            } else {
                st.push(Integer.valueOf(s));
            }
        } 

        return st.pop();
    }
}
