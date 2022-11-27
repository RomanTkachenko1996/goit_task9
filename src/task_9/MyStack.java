package task_9;

import java.util.Arrays;
import java.util.Stack;

/**
 * My own implementation of Stack collection
 * - push(T value) +
 * - remove(int index) +
 * - clear() +
 * - size() +
 * - peek()
 * - pop()
 * - toString()
 *
 * @param <T> generic types of allowed elements
 */
public class MyStack<T> {
    Node<T> first;
    Node<T> last;
    private int size;

    static class Node<T> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private void checkIfIndexAllowed(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

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
     * Method clears the whole stack
     */
    void clear() {
       first=last=null;
       size = 0;
    }

    /**
     * Method returns the size of the stack
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * Method returns the first element on the stack
     * @return 1st element
     */
    public T peek() {
        return last.element;
    }

    /**
     * Method removed the first element of the stack and returns that deleted element
     * @return 1st element, that was removed
     */
    public T pop() {
        Node<T> elementToRemove;
        if (size == 1){
            elementToRemove = first;
            first = last = null;
        } else {
            elementToRemove = getNodeByIndex(size-1);
            Node <T> prev = getNodeByIndex(size-2);
            prev.next = last;
            last = prev;
        }
        size--;
        return elementToRemove.element;
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
