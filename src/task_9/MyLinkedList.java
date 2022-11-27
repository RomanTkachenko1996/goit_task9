package task_9;

import java.util.Arrays;

public class MyLinkedList<T> { private static int size = 0;
   private Node<T> first;
    private Node<T> last;

    private static class Node<T> {
        T element;
        Node<T> next;
        Node( T element) {
            this.element = element;
        }
    }

    public void add(T element) {
        Node <T> newNode = new Node<>(element);
        if (first == null){
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }
    public void add(T element, int index) {
        checkIndex(index);
        Node <T> newNode = new Node<>(element);
        if (first == null){
            first = last = newNode;
        } else if (index == 0) {
            last.next = newNode;
            last = newNode;
        } else {
            Node<T> current = getNodeByIndex(index-1);
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
    }

    private Node<T> getNodeByIndex(int index) {
        Node <T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public T remove(int index) {
        checkIndex(index);
        T elementToRemove;
        if (index == 0){
            elementToRemove = first.element;
            first = first.next;
            if (first == null){
               last = null;
            }
        } else{
            Node<T> prev = getNodeByIndex(index - 1);
            elementToRemove = prev.next.element;
            prev.next = prev.next.next;
            if (index == size-1){
                last = prev;
            }
        }
        size--;
        return elementToRemove;
    }

    public void clear() {
        first = last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        checkIndex(index);
        return getNodeByIndex(index).element;
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