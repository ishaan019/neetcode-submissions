class Solution {
    public String foreignDictionary(String[] words) {
        int n = words.length;

        List<List<Integer>> adjList = new ArrayList<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for(int i = 0; i < 26; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree.putIfAbsent(c - 'a', 0);
            }
        }

        for(int i = 0; i < n - 1; i++) {
           String first = words[i];
           String second = words[i + 1];

           if (first.length() > second.length() && first.startsWith(second)) return "";

           int len = Math.min(first.length(), second.length());

           for(int j = 0; j < len; j++) {
            if(first.charAt(j) != second.charAt(j)) {
                adjList.get(first.charAt(j) - 'a').add(second.charAt(j) - 'a');
                indegree.put(second.charAt(j) - 'a', indegree.get(second.charAt(j) - 'a') + 1);
                break;
            }
           }
        }

       String list = topo(adjList, indegree);
       return list;
    }

    String topo(List<List<Integer>> adjList, Map<Integer, Integer> indegree) {
        Queue<Integer> q = new LinkedList<>();

        for(int c : indegree.keySet()) {
            if(indegree.get(c) == 0) {
                q.offer(c);
            }
        }

        StringBuilder res = new StringBuilder();

        while(!q.isEmpty()) {
            int top = q.poll();
            res.append((char) (top + 'a'));
            for(int nbr : adjList.get(top)) {
                indegree.put(nbr, indegree.get(nbr) - 1);
                if(indegree.get(nbr) == 0) {
                    q.offer(nbr);
                }
            }
        }

        if (res.length() != indegree.size()) {
            return "";
        }

        return res.toString();
    }
}