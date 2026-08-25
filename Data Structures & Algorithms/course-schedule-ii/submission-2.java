class Solution {

    //a,b
    //b->a
    //Topological Sort//Kahn's Algo

    //[[0,1],[1,2],[2,0]]
    //2->1->0->2
    //[1,0],[1,2],[0,1]]
    //0<->1
    //2->1
    

    // [1,0],[1,2],[0,1]
    public int[] findOrder(int numCourses, int[][] prerequisites) {//3

        Map<Integer, List<Integer>> adjList = new HashMap<>(); 

        int[] indegree = new int[numCourses];//0,0,0

        //fill empty List into adjList
        for(int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());//[][][]
        }

        //fill prerequisites into adjList
        for(int[] arr : prerequisites) {
            int u = arr[1];//from
            int v = arr[0];//to

            adjList.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        //fill the queue with indegree 0
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        List<Integer> order = new ArrayList<>();

        while(!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);

            for(int nbr : adjList.get(node)) {
                indegree[nbr]--;

                if(indegree[nbr] == 0) {
                    queue.offer(nbr);
                }
            }
        }

         for(int i = 0; i < numCourses; i++) {
            if(indegree[i] != 0) {
                return new int[0];
            }
        }

        System.out.println(order);

        int[] res = new int[order.size()];

        for(int i = 0; i < res.length; i++) {
            res[i] = order.get(i);
        }

        return res;
    }
}
