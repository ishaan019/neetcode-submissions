class Solution {
    public String foreignDictionary(String[] words) {

        //I need to create a map for adjList
        Map<Integer,List<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < 26; i++) {
            adjList.put(i, new ArrayList<>());
        }

        //create a indgree map
        Map<Integer, Integer> indegree = new HashMap<>();

        //words = ["hrn","hrf","er","enn","rfnn"]
        //fill the indegree
        for(String word : words) {
            for(char ch : word.toCharArray()) {
                indegree.put(ch - 'a', 0);
            }
        }

        //fill the adjList
        for(int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if(word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                Character ch1 = word1.charAt(j);
                Character ch2 = word2.charAt(j);

                if(ch1 == ch2) {
                    continue;
                } else {
                    int u = ch1 - 'a';//from
                    int v = ch2 - 'a';//to
                    adjList.get(u).add(v);

                    indegree.put(v, indegree.get(v) + 1);
                    break;
                }
            }
        }

        //apply kahn's algo
        //1. Put indegree 0 into the queues
        //2. Get node from queue and decrement the nbr indegree by 1
        //3. if indegree(nbr) == 0, put it into queue
        //4. return order

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        for(Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if(entry.getValue() == 0) {
                queue.offer(entry.getKey());
                visited.add(entry.getKey());
            }
        }

        StringBuilder order = new StringBuilder();

        while(!queue.isEmpty()) {
            int node = queue.poll();

            char ch1 = (char) (node + 'a');

            order.append(ch1);

            for(Integer nbr : adjList.get(node)) {
                indegree.put(nbr, indegree.get(nbr) - 1);

                if(indegree.get(nbr) == 0) {
                     queue.offer(nbr);
                     visited.add(nbr);
                }
            }
        }

        //if topological sort not possible
        // for(Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
        //     if(entry.getValue() != 0) {
        //         return "";
        //     }
        // }

        if(visited.size() != indegree.size()) {
            return "";
        }

        return order.toString();
    }
}
