class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (int[] arr : prerequisites) {
            int u = arr[0];
            int v = arr[1];

            adjList.get(u).add(v);
        }

        boolean[] pathVisited = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == false) {
                if (cycleDetectionDfs(i, adjList, pathVisited, visited) == true) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean cycleDetectionDfs(
        int i, ArrayList<ArrayList<Integer>> adjList, boolean[] pathVisited, boolean[] visited) {
        visited[i] = true;
        pathVisited[i] = true;

        for (int nbr : adjList.get(i)) {
            if (visited[nbr] == false) {
                if (cycleDetectionDfs(nbr, adjList, pathVisited, visited) == true) {
                    return true;
                }
            }

            if (pathVisited[nbr] == true) {
                return true;
            }
        }

        pathVisited[i] = false;
        return false;
    }
}
