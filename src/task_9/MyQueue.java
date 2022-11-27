package task_9;

/**
 * My own implementation of Queue collection
 * - add(T element)
 * - peek()
 * - poll()
 * <p>
 * From Nodes class:
 * - clear()
 * - size()
 * - toString()
 *
 * @param <T> generic types of allowed elements
 */
public class MyQueue<T> extends Nodes<T> {

    /**
     * Method adds element to the end of the list
     *
     * @param element new element
     */
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
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
    public T peek() {
        return first.element;
    }

    /**
     * Retrieves and removes the head of this queue
     *
     * @return head of the queue
     */
    public T poll() {
        T elementToRemove = first.element;
        first = first.next;
        size--;
        return elementToRemove;

    }
}
