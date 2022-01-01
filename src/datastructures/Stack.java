package datastructures;

/**
 * Stack class implementation
 * works in LIFO (Last In First Out) manner
 * Stores data in Node class format
 *
 * @param <E>
 */
public class Stack<E> {

    private Node<E> top;
    private E data;
    private int size;

    public static void main(String[] args) {
        System.out.println("Testing Stack");
        Stack<Integer> s = new Stack<>();
        System.out.println("Pushing 1 into stack: " + s.push(1));
        s.print();
        System.out.println("Pushing 6 into stack: " + s.push(6));
        s.print();
        System.out.println("Pushing 2 into stack: " + s.push(2));
        s.print();
        System.out.println("Pushing 5 into stack: " + s.push(5));
        s.print();
        System.out.println("Pushing 3 into stack: " + s.push(3));
        s.print();
        System.out.println("Pop stack: " + s.pop());
        s.print();
        System.out.println("Pop stack: " + s.pop());
        s.print();
        System.out.println("Pop stack: " + s.pop());
        s.print();
        System.out.println("Pop stack: " + s.pop());
        s.print();
        System.out.println("Pop stack: " + s.pop());
        s.print();
        System.out.println("Pop stack: " + s.pop());
        s.print();

    }


    /**
     * Pushes data to Stack and assigns it as the top most element
     * @param data
     * @return boolean
     */
    public boolean push(E data) {
        if (top == null) {
            top = new Node<>(data, null);
        } else {
            Node<E> currentTop = top;
            top = new Node(data, currentTop);
        }
        size++;
        return true;
    }

    /**
     * Removes top most element from Stack and assigns next element as its top
     * @return top
     */
    public E pop() {
        if (top == null) {
            return null;
        }
        Node<E> currentTop = top;
        E element = currentTop.getData();
        top = currentTop.getNext();
        currentTop.setNext(null);
        size--;
        return element;
    }

    /**
     * Prints Stack to System.out
     */
    public void print(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Node<E> cursorNode = top;
        while (true) {
            sb.append(cursorNode.getData());
            if(cursorNode.getNext() == null){
                return sb.append("]").toString();
            }
            sb.append(',').append(' ');
            cursorNode = cursorNode.getNext();
        }
    }

    /**
     * Returns current size of the Stack
     * @return size
     */
    public int getSize() {
        return size;
    }

}
