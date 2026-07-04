class Solution {

    class Pair {
        int val;
        int freq;
        Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        //save everything in hashmap to maintain frequency map


        HashMap<Integer, Integer> map = new HashMap<>();

        List<Integer> list = new ArrayList<>();

        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.freq - b.freq);


        for(Integer key : map.keySet()) {
            int val = map.get(key);

            pq.offer(new Pair(key, val));

            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[pq.size()];
        int i = 0;
        while(!pq.isEmpty()) {
            Pair top = pq.poll();
            ans[i++] = top.val;
        }

        return ans;
    }
}
