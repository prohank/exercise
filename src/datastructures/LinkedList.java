package datastructures;


/**
 * LinkedList implementation class
 *
 * @param <E>
 */
public class LinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    LinkedList() {
    }

    LinkedList(E data) {
        head = new Node<>(data, null);
        tail = head;
        size++;
    }

    /**
     * Add element at the first position in the linked list
     *
     * @param data
     * @return
     */
    public boolean addFirst(E data) {
        Node<E> newNode = new Node<>(data, head);
        if (head == null) head = tail = newNode;
        else {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
        return true;
    }

    /**
     * Add element at the last position in the linked list
     *
     * @param data
     * @return
     */
    public boolean addLast(E data) {
        Node<E> newNode = new Node<>(data, null);
        if (tail == null) head = tail = newNode;
        else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
        return true;
    }

    /**
     * Remove all elements from the linked list that match the argument
     *
     * @param data
     * @return
     */
    public boolean delete(E data) {
        boolean found = false;
        if (head == null) return false;

        Node<E> n = head;
        Node<E> previous = null;
        while (null != n) {
            Node<E> next = n.getNext();
            if (n.getData().equals(data)) {
                if (previous == null && next == null) {
                    size--;
                    return true;
                }
                if (previous == null) {
                    head = next;
                } else if (next == null) {
                    previous.setNext(null);
                    tail = previous;
                } else {
                    previous.setNext(next);
                }
                n.setNext(null);
                size--;
                found = true;
            } else previous = n;
            n = next;
        }
        return found;
    }

    /**
     * Look up for the input data in linked list
     *
     * @param data
     * @return
     */
    public boolean find(E data) {
        if (head == null) return false;
        Node<E> node = head;
        while (null != node.getNext()) {
            if (node.getData().equals(data)) return true;
            node = node.getNext();
        }
        return false;
    }

    /**
     * Gets the size of the linked list
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Prints out the elements in the linked list
     *
     * @param list
     */
    public void print(LinkedList<E> list) {
        System.out.println(list.toString());
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        Node<E> node = head;
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (true) {
            E e = node.getData();
            sb.append(e);
            if (null == node.getNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
            node = node.getNext();
        }
    }


    /**
     * Node class for storing data and reference of adjacent node in linkedlist
     *
     * @param <E>
     */
    private static class Node<E> {
        private Node<E> next;
        private E data;

        Node(E data, Node<E> node) {
            this.data = data;
            this.next = node;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node<?> node = (Node<?>) o;

            if (next != null ? !next.equals(node.next) : node.next != null) return false;
            return data.equals(node.data);
        }

        @Override
        public int hashCode() {
            int result = next != null ? next.hashCode() : 0;
            result = 31 * result + data.hashCode();
            return result;
        }
    }


    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Testing LinkedList");
        LinkedList<String> ll = new LinkedList<>("first");
        System.out.println("Adding elements into list");
        ll.addFirst("first");
        ll.print(ll);
        ll.addFirst("first");
        ll.print(ll);
        ll.addLast("second");
        ll.print(ll);
        ll.addLast("third");
        ll.print(ll);
        ll.addLast("fourth");
        ll.print(ll);
        ll.addLast("last");
        ll.print(ll);
        System.out.println("Deleting unknown from list:" + ll.delete("unknown"));
        ll.print(ll);
        System.out.println("Deleting first from list:" + ll.delete("first"));
        ll.print(ll);
        System.out.println("Deleting last from list:" + ll.delete("last"));
        ll.print(ll);
        System.out.println("Deleting third from list:" + ll.delete("third"));
        ll.print(ll);
        System.out.println("List size: " + ll.getSize());
        System.out.println("Find first: " + ll.find("first"));
        System.out.println("Find tenth: " + ll.find("second"));
    }
}