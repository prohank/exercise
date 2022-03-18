package competitive.leetcode.easy;

import competitive.leetcode.ListNode;
import datastructures.LinkedList;
import datastructures.Node;

import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * Date: 18-03-2022
 */
public class PalindromeList {
    public static void main(String[] args) {
        ListNode list1 = createLinkedList(new int[]{}); //true
        ListNode list2 = createLinkedList(new int[]{1}); //true
        ListNode list3 = createLinkedList(new int[]{1, 1}); //true
        ListNode list4 = createLinkedList(new int[]{1, 5}); //false
        ListNode list5 = createLinkedList(new int[]{1, 2, 2, 1}); //true
        ListNode list6 = createLinkedList(new int[]{1, 1, 2, 1}); //false
        ListNode list7 = createLinkedList(new int[]{1, 5, 6, 5, 1}); //true
        ListNode list8 = createLinkedList(new int[]{1, 5, 6, 5, 5}); //false
        ListNode list9 = createLinkedList(new int[]{1, 2, 6, 5, 1}); //false
        System.out.println(PalindromeList.isPalindrome(list1));
        System.out.println(PalindromeList.isPalindrome(list2));
        System.out.println(PalindromeList.isPalindrome(list3));
        System.out.println(PalindromeList.isPalindrome(list4));
        System.out.println(PalindromeList.isPalindrome(list5));
        System.out.println(PalindromeList.isPalindrome(list6));
        System.out.println(PalindromeList.isPalindrome(list7));
        System.out.println(PalindromeList.isPalindrome(list8));
        System.out.println(PalindromeList.isPalindrome(list9));
    }

    /**
     * (1) Move: fast reaches the end, slow arrives at the middle.
     *
     * 1 -> 1 -> 2 -> 1 -> null
     *           s          f
     * (2) Reverse: reverse right half, slow is the 2nd head.
     *
     * 1 -> 1    null <- 2 <- 1
     * h                      s
     * (3) Compare: run the two pointers head and slow and compare.
     *
     * 1 -> 1    null <- 2 <- 1
     *      h            s
     * In this example, since slow.val != head.val and thus slow != null, return false
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        while(slow != null && head.val == slow.val){
            slow = slow.next;
            head = head.next;
        }
        return slow == null;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

//    Approach - 2
//    public static boolean isPalindrome(ListNode head) {
//        if(head == null) {
//            return true;
//        }
//        ListNode p1 = head;
//        ListNode p2 = head;
//        ListNode p3 = p1.next;
//        ListNode pre = p1;
//        //find mid pointer, and reverse head half part
//        while(p2.next != null && p2.next.next != null) {
//            p2 = p2.next.next;
//            pre = p1;
//            p1 = p3;
//            p3 = p3.next;
//            p1.next = pre;
//        }
//
//        //odd number of elements, need left move p1 one step
//        if(p2.next == null) {
//            p1 = p1.next;
//        }
//        else {   //even number of elements, do nothing
//
//        }
//        //compare from mid to head/tail
//        while(p3 != null) {
//            if(p1.val != p3.val) {
//                return false;
//            }
//            p1 = p1.next;
//            p3 = p3.next;
//        }
//        return true;
//
//    }

    private static ListNode createLinkedList(int[] arr) {
        ListNode head = null;
        ListNode node = head;
        for (int i : arr) {
            if (head == null) {
                head = node = new ListNode(i);
            } else {
                node.next = new ListNode(i);
                node = node.next;
            }
        }
        return head;
    }
}
