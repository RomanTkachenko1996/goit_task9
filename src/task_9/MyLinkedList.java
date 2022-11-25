package task_9;

import java.util.Arrays;

public class MyLinkedList<T> {
    static int size = 0;
    Node<T> head;
    Node<T> tale;
    Node<T> next;

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public void add(T value) {
        Node<T> previousNode = tale;
        Node<T> newNode = new Node<>(previousNode, value, null);
        tale = newNode;
        if (previousNode == null) {
            head = newNode;
        } else {
            previousNode.next = newNode;
        }
        size++;
    }

    public T remove(int index) {
        Node<T> x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        T element = x.item;
        Node<T> next = x.next;
        Node<T> prev = x.prev;
        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            tale = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    public boolean clear() {
        next = null;
        head = null;
        tale = null;
        size = 0;
        return true;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        Node<T> x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x.item;
    }

    @Override
    public String toString() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<T> x = head; x != null; x = x.next) {
            result[i++] = x.item;
        }
        return Arrays.toString(result);
    }
}