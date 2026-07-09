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
        if(node == null)
            return null;
        if(node.neighbors.size() == 0)
            return new Node();
        
        Queue<Node> q = new ArrayDeque<>();
        HashMap<Node, Node> oldToNew = new HashMap();

        q.add(node);
        while(!q.isEmpty()){
            Node temp = q.poll();
            Node newNode = new Node(temp.val);
            oldToNew.put(temp, newNode);
            for(Node n: temp.neighbors){
                if(!oldToNew.containsKey(n)){
                    q.add(n);
                }
            }
        }

        for(Node n : oldToNew.keySet()){
            Node newNode = oldToNew.get(n);
            List<Node> newList = new ArrayList();
            for(Node nei : n.neighbors){
                newList.add(oldToNew.get(nei));
            }
            newNode.neighbors = newList;
        }

        return oldToNew.get(node);
    }
}