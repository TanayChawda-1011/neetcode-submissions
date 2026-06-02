class LinkedList {
    public class ListNode {
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

    private ListNode head;
    private ListNode tail;

    public LinkedList() {
        head = tail = null;
    }

    public int get(int index) {
        if(head == null)
            return -1;
        
        ListNode cur = head;
        int i = 0;

        while(cur != null) {
            if(i == index)
                return cur.val;
            i++;
            cur = cur.next;
        }

        return -1;
    }

    public void insertHead(int val) {
        ListNode newNode = new ListNode(val);

        if(head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertTail(int val) {
        ListNode newNode = new ListNode(val);
        
        if(head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public boolean remove(int index) {
        if(head == null)
            return false;

        if(index == 0) {
            if(head == tail)
                head = tail = null;
            else {
                head = head.next;
            }
            return true;
        }

        int i = 0;
        ListNode cur = head;

        while(i < index - 1 && cur != null) {
            i++;
            cur = cur.next;
        }

        if(cur != null && cur.next != null) {
            if(cur.next == tail)
                tail = cur;
            cur.next = cur.next.next;
            return true;
        }

        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> ll = new ArrayList<Integer>();
        ListNode cur = head;

        while(cur != null) {
            ll.add(cur.val);
            cur = cur.next;
        }

        return ll;
    }
}
