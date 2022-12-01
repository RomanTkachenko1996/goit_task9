package task_9;

/**
 * My own implementation of Queue collection
 * - add(E element)
 * - peek()
 * - poll()
 * <p>
 * From Nodes class:
 * - clear()
 * - size()
 * - toString()
 *
 * @param <E> generic types of allowed elements
 */
public class MyQueue<E> extends Nodes<E> {

    /**
     * Method adds element to the end of the list
     *
     * @param element new element
     */
    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (size == 0) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    /**
     * Retrieves, but does not remove, the head of this queue
     *
     * @return head of the queue
     */
    public E peek() {
        return first.element;
    }

    /**
     * Retrieves and removes the head of this queue (FIFO)
     *
     * @return head of the queue
     */
    public E poll() {
        Node<E> elementToRemove;
        if (size == 1) {
            elementToRemove = first;
            first = last = null;
        } else {
            elementToRemove = first;
            first = first.next;
        }
        size--;
        return elementToRemove.element;
    }
}
