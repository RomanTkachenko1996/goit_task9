package task_9;

import java.util.Arrays;

/**
 * Parent class the introduces each particular Entry as separate new object
 * in the chain for MyLinkedList/MyQueue/MyStack.
 * It has common fields and methods for all the child classes.
 *
 * @param <E> generic type of element
 */
class Nodes<E> {
    protected int size;
    Node<E> first;
    Node<E> last;

    static class Node<E> {
        E element;
        Node<E> next;
        public Node(E element) {
            this.element = element;
        }
    }

    /**
     * O(n) operation for the chain to find the element by the given index
     *
     * @param index passed index
     * @return found node by the given index
     */
     Node<E> getNodeByIndex(int index) {
        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * Checks if the index is traceable in the chain
     *
     * @param index passed index
     */
    void checkIfIndexAllowed(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Method clears the nodes chain
     */
    public void clear() {
        first = last = null;
        size = 0;
    }

    /**
     * Method returns the size of the nodes chain
     *
     * @return size
     */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Object[] objects = new Object[size];
        for (int i = 0; i < size; i++) {
            objects[i] = getNodeByIndex(i).element;
        }
        return Arrays.toString(objects);
    }
}
