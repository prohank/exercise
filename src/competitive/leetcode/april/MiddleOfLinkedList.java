package competitive.leetcode.april;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class MiddleOfLinkedList {
    public static void main(String[] args) {
        MiddleOfLinkedList mol = new MiddleOfLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(mol.middleNode(head).val);
    }

    public ListNode middleNode(ListNode head) {
        ListNode currentNode = head;
        int count = 0;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        int mid = count / 2;
        int i = 0;
        currentNode = head;
        while(i < mid){
            currentNode = currentNode.next;
            i++;
        }
        return currentNode;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

///////////////////////////////////////////////////
/*public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next !=null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    return slow;
}*/