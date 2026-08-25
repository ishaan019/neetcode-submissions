class Solution {
    // 1->0
    // in [a,b]] = b->a

    // canFinish

    // 0 <-> 1
    // 1.    1

    // TC = O(V + E)
    // SC = O(V)

    // Input: numCourses = 2, prerequisites = [[0,1],[1,0]]

    // Output: false

    // 1 -> 0
    // 0.   0

    // queue =
    // order = 1 0
    // Input: numCourses = 2, prerequisites = [[0,1]]

    // Output: true
    // find the indegree of every vertex

    // Make a queue, pull all 0 indegree into that
    // Get the element out at the top
    // Decrement the indegree of the adjacents
    // and if some vertex have degree 0 then we will put into the queue

    public boolean canFinish(int numCourses, int[][] prerequisites) {//2, [0,1],[1,0]
        // Prepare a graph -> will containing nodes
        // Adjacenecy list
        Map<Integer, List<Integer>> adjList = new HashMap<>();//[key, value as list<integer>]
        int[] indegree = new int[numCourses];//[0,0]

        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());
            //[0-> []]
            //[1-> [0]]
        }

        for (int[] arr : prerequisites) {
            int u = arr[1]; // from
            int v = arr[0]; // to
            adjList.get(u).add(v);

            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);//1
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();//1

            for (int nbr : adjList.get(node)) {//[0]
                indegree[nbr]--;

                if (indegree[nbr] == 0) {
                    queue.offer(nbr);
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] != 0) {
                return false;
            }
        }

        return true;
    }
}