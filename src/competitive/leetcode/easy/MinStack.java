package competitive.leetcode.easy;

/**
 * https://leetcode.com/problems/min-stack/
 * Date: 10-05-2020
 */
public class MinStack {

    private Node stack_top;

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        System.out.println(minStack.getMin()); // return -3
//        minStack.pop();
//        System.out.println(minStack.top());    // return 0
//        System.out.println(minStack.getMin()); // return -2

        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println("top " + minStack.top());
        minStack.pop();
        System.out.println("min " + minStack.getMin());
        minStack.pop();
        System.out.println("min " + minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println("top " + minStack.top());
        System.out.println("min " + minStack.getMin());
        minStack.push(-2147483648);
        System.out.println("top " + minStack.top());
        System.out.println("min " + minStack.getMin());
        minStack.pop();
        System.out.println("min " + minStack.getMin());
    }

    public MinStack() {

    }

    public void push(int x) {
        Node newNode = new Node(x);
        newNode.setNext(stack_top);
        stack_top = newNode;
    }

    public void pop() {
        if (stack_top != null) {
            stack_top = stack_top.getNext();
        }
    }

    public int top() {
        if (stack_top != null) return stack_top.getData();
        return 0;
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        Node currentNode = stack_top;
        while (currentNode != null) {
            if (min > currentNode.getData()) min = currentNode.getData();
            currentNode = currentNode.getNext();
        }
        return min;
    }

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
