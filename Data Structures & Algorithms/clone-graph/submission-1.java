/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();//old -> new

        Node newNode = new Node(node.val);

        map.put(node, newNode);

        //apply bfs
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            Node top = queue.poll();

            for(Node nbr : top.neighbors) {
                if(!map.containsKey(nbr)) {
                    //just attach it
                    Node newNbr = new Node(nbr.val);
                    map.put(nbr, newNbr);
                    queue.offer(nbr);
                }
                map.get(top).neighbors.add(map.get(nbr));
            }
        }

        return map.get(node);
    }
}