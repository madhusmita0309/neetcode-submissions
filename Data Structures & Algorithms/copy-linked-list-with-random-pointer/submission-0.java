/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp; Node curr = head;
        HashMap<Node, Node> oldToNewMap = new HashMap<>();
        oldToNewMap.put(null, null);

        while(curr != null){
            temp = new Node(curr.val);
            oldToNewMap.put(curr, temp);
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            Node newNode = oldToNewMap.get(curr);
            newNode.next = oldToNewMap.get(curr.next);
            newNode.random = oldToNewMap.get(curr.random);

            curr = curr.next;
        }


        return oldToNewMap.get(head);
    }
}
