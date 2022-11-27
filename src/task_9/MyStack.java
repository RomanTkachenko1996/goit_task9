package task_9;

/**
 * My own implementation of Stack collection (LIFO)
 * - push(T value)
 * - remove(int index)
 * - peek()
 * - pop()
 * <p>
 * From Nodes class:
 * - clear()
 * - size()
 * - toString()
 *
 * @param <T> generic types of allowed elements
 */
public class MyStack<T> extends Nodes<T> {
    /**
     * Method adds the element to the end of the stack
     *
     * @param element given element
     */
    public void push(T element) {
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
     * Method removes element by the given index
     *
     * @param index passed index to find the element
     * @return removed element
     */
    public T remove(int index) {
        checkIfIndexAllowed(index);
        T elementToRemove;
        if (index == 0) {
            elementToRemove = first.element;
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            Node<T> prev = getNodeByIndex(size - 1);
            elementToRemove = prev.next.element;
            prev.next = prev.next.next;
        }
        size--;
        return elementToRemove;
    }

    /**
     * Returns the object at the top of this stack (the last item)
     *
     * @return 1st element of the stack
     */
    public T peek() {
        return last.element;
    }

    /**
     * Removes the object at the top of this stack (the last item)
     *
     * @return 1st element of the stack
     */
    public T pop() {
        Node<T> elementToRemove;
        if (size == 1) {
            elementToRemove = first;
            first = last = null;
        } else {
            elementToRemove = getNodeByIndex(size - 1);
            Node<T> prev = getNodeByIndex(size - 2);
            prev.next = last;
            last = prev;
        }
        size--;
        return elementToRemove.element;
    }
}
