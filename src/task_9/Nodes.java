package task_9;

import java.util.Arrays;

class Nodes<T> {
    protected int size;
    Node<T> first;
    Node<T> last;

    Node<T> getNodeByIndex(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    void checkIfIndexAllowed(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }
    /**
     * Method clears the nodes chain
     */
    public void clear(){
        first = last = null;
        size = 0;
    }
    /**
     * Method returns the size of the nodes chain
     * @return size
     */
    public int size() {
        return size;
    }
    @Override
    public String toString() {
        Object[] objects = new Object[size];
        for (int i = 0; i < size; i++) {
            objects[i] = getNodeByIndex(i);
        }
        return Arrays.toString(objects);
    }

    static class Node<T> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }
}
