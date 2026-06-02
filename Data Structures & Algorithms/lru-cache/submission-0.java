class Node {
    int key, val;
    Node prev, next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = this.next = null;
    }
}

class LRUCache {
    private int cap;
    private Map<Integer, Node> cache;
    private Node left, right;

    public LRUCache(int capacity) {
        cap = capacity;
        cache = new HashMap<>();
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
    }

    public void insert(Node node) {
        Node prev = right.prev;
        prev.next = node;
        right.prev = node;
        node.prev = prev;
        node.next = right;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key))
            remove(cache.get(key));
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if(cache.size() > cap) {
            cache.remove(left.next.key);
            remove(left.next);
        }
    }
}
