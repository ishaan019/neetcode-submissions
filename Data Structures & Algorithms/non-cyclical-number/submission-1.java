class Solution {
    public boolean isHappy(int n) {
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();//2,4

        while(n != 1 && !set.contains(n)) {
            set.add(n);//19

            sum = 0;
            while(n != 0) {//2
                int rem = n % 10;//2
                n = n / 10;//0
                sum += rem * rem;//4
            }
            n = sum; 
        }

        return n == 1;
    }

    
}
