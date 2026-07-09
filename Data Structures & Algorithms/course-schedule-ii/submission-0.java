class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (int[] arr : prerequisites) {
            int u = arr[1];
            int v = arr[0];

            adjList.get(u).add(v);
        }

        boolean[] pathVisited = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == false) {
                if (dfs(i, adjList, visited, pathVisited, stack) == true) {
                    return new int[] {};
                }
            }
        }

        int ans[] = new int[stack.size()];
        int i = 0;
        while (stack.isEmpty() == false) {
            ans[i] = stack.pop();
            i++;
        }

        return ans;
    }

    boolean dfs(int i, ArrayList<ArrayList<Integer>> adjList, boolean[] visited,
        boolean[] pathVisited, Stack stack) {
        visited[i] = true;
        pathVisited[i] = true;

        for (int nbr : adjList.get(i)) {
            if (visited[nbr] == false) {
                if (dfs(nbr, adjList, visited, pathVisited, stack)) {
                    return true;
                }
            }

            if (pathVisited[nbr] == true) {
                return true;
            }
        }

        stack.push(i);

        pathVisited[i] = false;
        return false;
    }
}
