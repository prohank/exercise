package datastructures;


/**
 * Node class for storing data and reference of adjacent node in linkedlist
 *
 * @param <E>
 */
public class Node<E> {
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