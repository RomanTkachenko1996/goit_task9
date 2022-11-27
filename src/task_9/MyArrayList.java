package task_9;

import java.util.Arrays;

/**
 * Implements my own ArrayList collection with methods:
 * - add(T element)
 * - remove(int index)
 * - clear()
 * - get(int index)
 * - size()
 * - toString()
 *
 * @param <T> generic types of allowed elements
 */
public class MyArrayList<T> {
    private Object[] data;
    private int index;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        } else {
            data = new Object[capacity];
        }

    }

    public MyArrayList() {
        this.data = new Object[8];
        index = 0;
    }

    /**
     * Method adds element to the end of the list
     * @param value value to add
     */
    public void add(T value) {
        increaseSize();
        data[index] = value;
        index++;
    }

    private void increaseSize() {
        if (index == data.length) {
            Object[] copy = new Object[data.length * 2];
            System.arraycopy(data, 0, copy, 0, data.length);
            data = copy;
        }
    }

    /**
     * Removed the element given by index in the list
     * @param indexInArray index passed to find the element
     * @return removed element
     */
    public Object remove(int indexInArray) {
        if (indexInArray < 0 || indexInArray >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            Object valueToRemove = data[indexInArray];
            Object[] copy = new Object[data.length];
            if (indexInArray == 0) {
                System.arraycopy(data, 1, copy, 0, data.length - 1);
            } else {
                Object[] copyLeft = Arrays.copyOfRange(data, 0, indexInArray);
                Object[] copyRight = Arrays.copyOfRange(data, indexInArray + 1, data.length - 1);
                System.arraycopy(copyLeft, 0, copy, 0, copyLeft.length);
                System.arraycopy(copyRight, 0, copy, indexInArray, copyRight.length);
            }
            data = copy;
            index--;
            return valueToRemove;
        }
    }

    /**
     * Method clears the list
     */
    public void clear() {
        data = new Object[8];
        index = 0;
    }

    /**
     * Method returns the list size
     * @return size of the list
     */
    public int size() {
        return index;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        return (builder.append(Arrays.toString(data))).toString();
    }

    /**
     * Method returns the element by the given index
     * @param index passed index to find the element
     * @return the element
     */
    public Object get(int index) {
        return data[index];
    }
}
