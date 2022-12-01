package task_9;

import java.util.Objects;

public class MyHashMap<K, V>{
    private static final int CAPACITY = 10;
    Node<K, V>[] buckets = (Node<K, V>[]) new Node[CAPACITY];
    int size;

    static class Node<K, V> {
        Node<K, V> next;
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    public void put(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        int bucket = Math.abs(Objects.hashCode(key)) % 10;
        if (buckets[bucket] == null) {
            buckets[bucket] = newNode;
            size++;
        } else {
            if (newNode.key.equals(buckets[bucket].key)) {
                buckets[bucket].value = newNode.value;
            } else {
                Node<K, V> current = buckets[bucket];
                while (current.next != null) {
                    current = current.next;
                }
                Node<K, V> lastNode = current;
                lastNode.next = newNode;
                size++;
            }
        }
    }

    public V get(K key) {
        int bucket = Math.abs(Objects.hashCode(key)) % 10;
        V value = null;
        if (buckets[bucket] == null) {
            throw new IllegalArgumentException();
        } else {
            Node<K, V> current = buckets[bucket];
            do {
                if (current.key.equals(key)) {
                    value = current.value;
                }
                current = current.next;
            } while (current != null);
        }
        return value;
    }

    V remove(K key) {
       return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("qewrqwerqwrqwer", "1");
        map.put("qwerqwrq", "2");
        map.put("qwerwqwrq", "3");
        map.put("werwer", "4");
        map.put("wer", "5");
        map.put("2t4", "6");
        map.put("ert", "7");
        map.put("er", "8");
        map.put("3453dsf", "9");
        map.put("aerqwer", "10");
        map.put("43", "11");
        System.out.println("map.get(\"email1\") = " + map.get("aerqwer"));
        System.out.println("map.get(\"email2\") = " + map.get("43"));
        System.out.println("map.get(\"email3\") = " + map.get("11"));
    }
}
