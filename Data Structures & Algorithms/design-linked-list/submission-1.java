class MyLinkedList {
    public class ListNode {
        int val;
        ListNode next, prev;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next, ListNode prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    private ListNode head, tail;
    private int length;

    public MyLinkedList() {
        head = tail = null;
    }
    
    public int get(int index) {
        if(head == null)    return -1;

        if(index >= length)
            return -1;
        
        ListNode cur = head;
        int i = 0;

        while(i < index && cur != null) {
            cur = cur.next;
            i++;
        }

        return cur == null ? -1 : cur.val;
    }
    
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        
        if(head == null)
            head = tail = newNode;
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }
    
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        
        if(head == null)
            head = tail = newNode;
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }
    
    public void addAtIndex(int index, int val) {
        ListNode newNode = new ListNode(val);

        if(index > length)
            return;

        if(index == 0) {
            addAtHead(val);
            return;
        }
        
        if(index == length) {
            addAtTail(val);
            return;
        }

        ListNode cur = head;
        int i = 0;

        while(i < index && cur != null) {
            cur = cur.next;
            i++;
        }

        if(cur == null)     return;
        
        newNode.next = cur;
        newNode.prev = cur.prev;
        cur.prev.next = newNode;
        cur.prev = newNode;          

        length++;
    }
    
    public void deleteAtIndex(int index) {
        if(index >= length)
            return;

        if(index == 0) {
            if(head == null)
                return;
            if(head == tail)
                head = tail = null;
            else {
                head = head.next;
                head.prev = null;
            }
            length--;
            return;
        }

        if(index == length - 1) {
            tail = tail.prev;
            tail.next = null;
            length--;
            return;
        }

        ListNode cur = head;
        int i = 0;

        while(i < index && cur != null) {
            cur = cur.next;
            i++;
        }

        if(cur == null)    return;

        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */