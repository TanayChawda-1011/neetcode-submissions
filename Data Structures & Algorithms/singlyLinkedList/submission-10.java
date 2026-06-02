class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class LinkedList {
    private ListNode head;
    private ListNode tail;


    public LinkedList() {
        head = null;
        tail = head;
    }

    public int get(int index) {
        if(head == null)
            return -1;
        
        ListNode curr = head;
        int i = 0;

        while(curr != null) {
            if(i == index)
                return curr.val;
            curr = curr.next;
            i++;
        }
        return -1;
    }

    public void insertHead(int val) {
        ListNode newNode = new ListNode(val);

        if(head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void insertTail(int val) {
        ListNode newNode = new ListNode(val);

        if(head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public boolean remove(int index) {
    if (head == null) // Empty list
        return false;

    if (index == 0) { // Special case: removing the head
        if (head == tail) { // Only one node in the list
            head = tail = null;
        } else {
            head = head.next; // Move head to the next node
        }
        return true;
    }

    ListNode curr = head;
    int i = 0;

    // Traverse the list to find the node at the given index
    while (i < index - 1 && curr != null) { // Fix: stop at node before the target
        i++;
        curr = curr.next;
    }

    // If index is out of bounds or we are at the last node
    if (curr == null || curr.next == null) {
        return false;
    }

    // Remove the node
    if (curr.next == tail) {
        tail = curr; // Update tail if we're removing the last element
    }
    curr.next = curr.next.next;

    return true;
}


    public ArrayList<Integer> getValues() {
        ArrayList<Integer> ll = new ArrayList<Integer>();

        ListNode curr = head;

        while(curr != null) {
            ll.add(curr.val);
            curr = curr.next;
        }

        return ll;
    }
}
