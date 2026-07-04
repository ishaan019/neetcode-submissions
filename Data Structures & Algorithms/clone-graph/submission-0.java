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
            return node;
        }

        HashMap<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(q.isEmpty() == false) {
            Node top = q.poll();

            for(Node n : top.neighbors) {
                if(map.containsKey(n) == false) {
                    //add it
                    map.put(n, new Node(n.val));
                    q.add(n);
                }
                //do mapping
                map.get(top).neighbors.add(map.get(n));
            }
        }

        return map.get(node);        
    }
}