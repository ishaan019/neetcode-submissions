class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();//Value, count

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //min heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);//[value, count]

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[] {entry.getKey(), entry.getValue()});

            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];
        int i = 0;
        while(!pq.isEmpty()) {
            ans[i] = pq.poll()[0];
            i++;
        }

        return ans;
    }
}
