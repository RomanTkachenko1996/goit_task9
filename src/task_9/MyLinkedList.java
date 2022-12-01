package task_9;

/**
 * My own implementation of LinkedList collection with methods:
 * - add(E element)
 * - remove(int index)
 * - get(int index)
 * <p>
 * From Nodes class:
 * - clear()
 * - size()
 * - toString()
 *
 * @param <E> generic types of allowed elements
 */
public class MyLinkedList<E> extends Nodes<E> {

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
     * Method removed element found by index in the list
     *
     * @param index passed index
     * @return removed element
     */
    public E remove(int index) {
        checkIfIndexAllowed(index);
        E elementToRemove;
        if (index == 0) {
            elementToRemove = first.element;
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            Node<E> prev = getNodeByIndex(index - 1);
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
    public E get(int index) {
        checkIfIndexAllowed(index);
        return getNodeByIndex(index).element;
    }
}
