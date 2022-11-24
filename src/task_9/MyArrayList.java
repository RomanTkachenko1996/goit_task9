package task_9;

import java.util.Arrays;

public class MyArrayList {
    private int [] data = new int[8];
    int index = 0;
    public void add(int value) {
        increaseSize();
        data[index] = value;
        index++;
    }

    private void increaseSize() {
        if (index==data.length){
            int [] copy = new int[data.length*2];
            System.arraycopy(data,0,copy,0,data.length);
            data = copy;
        }
    }

    public void remove(int index) {
    }
    public void clear() {
        data = new int[8];
        index = 0;
    }
    public int size() {
        return index;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        return (builder.append(Arrays.toString(data))).toString();
    }

    public int get(int index) {
        return data[index];
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        for (int i = 0; i <10; i++) {
            list.add(10);
        }
        System.out.println("list = " + list);
        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("list.size() = " + list.size());
        list.clear();
        System.out.println("list = " + list);
        System.out.println("list.size() = " + list.size());


    }
}
