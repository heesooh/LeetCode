/*
// Definition for a Node.
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

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    private HashMap<Node, Node> seen = new HashMap<>();
    public Node cloneGraph(Node node) {
        // Edge case where node = null
        if (node == null) {
            return node;
        }

        // If we've seen the current node, return its copy
        if (seen.get(node) != null) {
            return seen.get(node);
        }

        // Otherwise, create a copy of the current node
        Node copy = new Node(node.val, new ArrayList<Node>());
        // Update the seen hashmap with the newly copied node
        seen.put(node, copy);

        // Perform recursion on each of current node's neighbours
        for (Node neighbor: node.neighbors) {
            // add the recursion result in the copy node's neighbors list
            copy.neighbors.add(cloneGraph(neighbor));
        }

        // return the copy of the current node
        // after recursion on its neighbours
        return copy;
    }
}