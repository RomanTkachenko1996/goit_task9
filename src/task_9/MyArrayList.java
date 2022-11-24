package task_9;

import java.util.Arrays;

public class MyArrayList <T> {
    private  T [] data;
    private int index;
    MyArrayList(int capacity){

        data = (T[]) new Object[capacity];
    }
    MyArrayList(){
       data = (T[]) new Object[8];
        index = 0;
    }

    public void add(T value) {
        increaseSize();
        data[index] = value;
        index++;
    }

    private void increaseSize() {
        if (index == data.length) {
            T[] copy = (T[])new Object[data.length * 2];
            System.arraycopy(data, 0, copy, 0, data.length);
            data = copy;
        }
    }

    public T remove(int indexInArray) {
        if (indexInArray < 0 || indexInArray >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            T valueToRemove = data[indexInArray];
            T [] copy = (T[])new Object[data.length];
            if (indexInArray == 0){
                System.arraycopy(data,1,copy,0,data.length-1);
                data = copy;
            } else {
                T [] copyLeft = Arrays.copyOfRange(data,0,indexInArray);
                T [] copyRight = Arrays.copyOfRange(data, indexInArray+1,data.length-1);
                System.arraycopy(copyLeft,0,copy,0,copyLeft.length);
                System.arraycopy(copyRight,0,copy,indexInArray,copyRight.length);
                data = copy;
            }
            index--;
            return valueToRemove;
        }
    }

    public boolean clear() {
        data = (T[])new Object[8];
        index = 0;
        return true;
    }

    public int size() {
        return index;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        return (builder.append(Arrays.toString(data))).toString();
    }

    public T get(int index) {
        return data[index];
    }
}
