package competitive.leetcode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * Date: 10-01-2022
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String sum = getSum(l1, l2);
        return createListNode(sum);
    }

    private String getSum(ListNode l1, ListNode l2) {
        StringBuilder sum = new StringBuilder();
        int carry = 0;
        while (l1 != null || l2 != null) {
            int temp = 0;
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }
            temp += carry;
            sum.append(temp % 10);
            carry = temp/10;
        }
        if (carry != 0) {
            sum.append(carry);
        }
        return sum.toString();
    }

    private ListNode createListNode(String num) {
        ListNode node = null;
        for (int i = num.length() - 1; i >= 0; i--) {
            node = new ListNode(Integer.parseInt("" + num.charAt(i)), node);
        }
        node = node == null ? new ListNode() : node;
        printList(node);
        return node;
    }

    private void printList(ListNode node) {
        ListNode tempNode = node;
        while (tempNode != null) {
            System.out.print(tempNode.val);
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AddTwoNumbers obj = new AddTwoNumbers();
        //        Test 1: OP=68036
        ListNode l1 = obj.createListNode("12345");
        ListNode l2 = obj.createListNode("5678");
        obj.addTwoNumbers(l1, l2);

        //        Test 2: OP=0
        ListNode l3 = obj.createListNode("0");
        ListNode l4 = obj.createListNode("0");
        obj.addTwoNumbers(l3, l4);

        //        Test 3: OP=708
        ListNode l5 = obj.createListNode("243");
        ListNode l6 = obj.createListNode("564");
        obj.addTwoNumbers(l5, l6);

        //        Test 4: OP=0101
        ListNode l7 = obj.createListNode("56");
        ListNode l8 = obj.createListNode("549");
        obj.addTwoNumbers(l7, l8);
    }
}