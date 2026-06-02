class LinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        ListNode(int val, ListNode next) {
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
        if(head == null)    return -1;

        ListNode cur = head;
        int i = 0;

        while(cur != null && i < index) {
            cur = cur.next;
            i++;
        }

        return cur == null ? -1 : cur.val;
    }

    public void insertHead(int val) {
        ListNode newNode = new ListNode(val);

        if(head == null)
            head = tail = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertTail(int val) {
        ListNode newNode = new ListNode(val);

        if(head == null)
            head = tail = newNode;
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public boolean remove(int index) {
        if(index == 0) {
            if(head == null)    return false;

            if(head == tail) {
                head = tail = null;
            }
            else {
                head = head.next;
            }
            return true;
        }

        ListNode cur = head;
        int i = 0;

        while(cur != null && i < index - 1) {
            cur = cur.next;
            i++;
        }

        // NOTE*: cur.next is actually the node we wanna delete! Cuz `i < index - 1`
        if(cur == null || cur.next == null)
            return false;

        if(cur.next == tail)
            tail = cur;

        cur.next = cur.next.next;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode cur = head;

        while(cur != null) {
            res.add(cur.val);
            cur = cur.next;
        }
        return res;
    }
}
