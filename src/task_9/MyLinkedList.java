package task_9;

/**
 * My own implementation of LinkedList collection with methods:
 * - add(T element)
 * - remove(int index)
 * - get(int index)
 * <p>
 * From Nodes class:
 * - clear()
 * - size()
 * - toString()
 *
 * @param <T> generic types of allowed elements
 */
public class MyLinkedList<T> extends Nodes<T> {

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
     * Method removed element found by index in the list
     *
     * @param index passed index
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
            Node<T> prev = getNodeByIndex(index - 1);
            elementToRemove = prev.next.element;
            prev.next = prev.next.next;
        }
        size--;
        return elementToRemove;
    }

    /**
     * Method returns the size of the list
     *
     * @return list size
     */
    public int size() {
        return size;
    }

    /**
     * Method gets element in list by the given index
     *
     * @param index passed index to find needed element
     * @return found element
     */
    public T get(int index) {
        checkIfIndexAllowed(index);
        return getNodeByIndex(index).element;
    }
}
