class LRUCache {

    int capacity;
    HashMap<Integer, Node> cache;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        if(this.cache.containsKey(key)){
            Node n = cache.get(key);
            remove(n);
            insert(n);
            return n.value;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(this.cache.containsKey(key)){
            remove(this.cache.get(key));
        }

        Node newNode = new Node(key, value);
        insert(newNode);
        this.cache.put(key, newNode);
        if(this.cache.size() > this.capacity){
            Node lru = this.left.next;
            remove(lru);
            this.cache.remove(lru.key);
        }
    }

    // remove node from left  - least recently used node
    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
        
    }

    // insert new node at right - most recent node
    public void insert(Node node){
        Node prev = this.right.prev;
        
        prev.next = node;
        node.prev = prev;

        node.next = this.right;
        this.right.prev = node;

    }

}

class Node{
    int key;
    int value;
    Node prev; 
    Node next;

    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
