class Solution {
    public int longestConsecutive(int[] nums) {
        int MAX = 1000000009;

        Set<Integer> set = new HashSet<>();

        for(int i : nums) {
            set.add(i);
        }

        int maxCount = 0;//4


        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()) {
            Integer top = iterator.next();
            int count = 1;
            // int top = set.get(nums[i]);//2

            //we will check, is it a starting point?
            //i will check for previous no. to exist, 
            int prev = top - 1;//1
            if(set.contains(prev)) {
                continue; // its not the starting
            } else {
                int next = top + 1;//3
                while(set.contains(next)) {
                    count++;//4
                    next = next + 1;//6
                }
            }
            maxCount = Math.max(maxCount, count);//4
            //if yes, then continue as it is not the starting point
            //if no, then count the next numbers avaialble by i++
            //and maintain the maxCount
        }

        return maxCount;
        
    }
}
