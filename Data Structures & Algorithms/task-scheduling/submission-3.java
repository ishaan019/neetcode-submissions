
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];

        for (char c : tasks) {
            arr[c - 'A']++;
        }

        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(b, a)); // {Frequency}

        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                maxHeap.offer(arr[i]);
            }
        }

        int time = 0;
        Queue<int[]> q = new ArrayDeque<>();// {Frequency, Time at which it would be available again}
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;//2

            if(maxHeap.isEmpty()) {
                time = q.peek()[1];
            } else {
                int curr = maxHeap.poll();
                int fr = curr - 1;

                if (fr > 0) {
                    q.offer(new int[] {fr, time + n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.poll()[0]);
            }
        }

        return time;
    }
}
