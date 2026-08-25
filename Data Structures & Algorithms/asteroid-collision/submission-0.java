class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        // put the astroids into the stack
        
        // cases
        // stack.peek() -ve and adding -ve hai taan add krde
        // stack.peek() -ve and adding +ve , add it
        // stack.peek() +ve and adding -ve , collision, remove peek add max into the stack
        // stack.peek() +ve and adding +ve , add it

        Stack<Integer> st = new Stack<>();
        
        for(int a : asteroids) {//5,10,-5
            boolean destroyed = false;
            while(!st.isEmpty() && st.peek() > 0 && a < 0) {
                int top = st.pop();
                if(Math.abs(a) > Math.abs(top)) {
                    a = a;
                } else if(Math.abs(a) == Math.abs(top)) {
                    destroyed = true;
                    break;
                }
                 else {
                    a = top;
                }
            }
            if(!destroyed)
                st.push(a);
        }

        int[] res = new int[st.size()];
        int n = res.length - 1;
        while(!st.isEmpty()) {
            res[n] = st.pop();
            n--;
        }

        return res;
    }
}