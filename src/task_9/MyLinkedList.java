package task_9;

import java.util.Arrays;

/**
 * My own implementation of LinkedList collection with methods:
 * - add(T element)
 * - remove(int index)
 * - clear()
 * - get(int index)
 * - size()
 * - toString()
 * @param <T> generic types of allowed elements
 */
public class MyLinkedList<T> {
    private Node<T> first;
    private Node<T> last;

    private int size;
    static class Node <T>{
        T element;
        Node <T> next;
        public Node(T element) {
            this.element = element;
        }
    }

    /**
     * Method adds element to the end of the list
     * @param element new element
     */
    public void add(T element){
        Node <T> newNode = new Node<>(element);
        if (size == 0){
            first = last = newNode;
        }else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    /**
     * Method removed element found by index in the list
     * @param index passed index
     * @return removed element
     */
    public T remove (int index){
        T elementToRemove;
        checkIfIndexAllowed(index);
        if (index == 0){
            elementToRemove = first.element;
            first = first.next;
            if (first == null){
                last = null;
            }
        } else{
            Node <T> prev = getElementByIndex(index-1);
            elementToRemove = prev.next.element;
            prev.next = prev.next.next;
        }
        size--;
        return elementToRemove;
    }

    private Node <T> getElementByIndex(int index) {
        Node <T> current = first;
        for (int i = 0; i < index; i++) {
            current  = current.next;
        }
        return current;
    }

    private void checkIfIndexAllowed(int index) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Method clears the chain
     */
    public void clear(){
        first = last = null;
        size = 0;
    }

    /**
     * Method returns the size of the list
     * @return list size
     */
    public int size(){
        return size;
    }

    /**
     * Method gets element in list by the given index
     * @param index passed index to find needed element
     * @return found element
     */
    public T get (int index){
        checkIfIndexAllowed(index);
        return getElementByIndex(index).element;
    }
    @Override
    public String toString() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<T> x = first; x != null; x = x.next) {
            result[i++] = x.element;
        }
        return Arrays.toString(result);
    }
}
