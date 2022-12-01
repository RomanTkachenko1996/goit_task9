package task_9;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * My own implementation of HashMap map with methods:
 * - put(K key)
 * - remove(K key)
 * - get(K key)
 * - clear()
 * - size()
 * - toString()
 *
 * @param <K> generic type for Key
 * @param <V> generic type for Value
 */
public class MyHashMap<K, V> {
    private static final int CAPACITY = 10;
    Entry<K, V>[] buckets = (Entry<K, V>[]) new Entry[CAPACITY];
    int size;

    static class Entry<K, V> {
        Entry<K, V> next;
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    /**
     * Puts the new entry to the map
     * 1. Finds the position in the array of buckets
     * 2. If the bucket is empty, we put entry there
     * 3. Else we check keys and collisions, rewrite value or put the entry to the end of the LinkedList within a bucket
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        Entry<K, V> newEntry = new Entry<>(key, value);
        int bucket = Math.abs(Objects.hashCode(key)) % 10;
        if (buckets[bucket] == null) {
            buckets[bucket] = newEntry;
            size++;
        } else {
            if (newEntry.key.equals(buckets[bucket].key)) {
                buckets[bucket].value = newEntry.value;
            } else {
                Entry<K, V> current = buckets[bucket];
                while (current.next != null) {
                    current = current.next;
                }
                Entry<K, V> lastEntry = current;
                lastEntry.next = newEntry;
                size++;
            }
        }
    }

    /**
     * Gets the entry: checks each entry and compares it with the key. If key found, returns the value of the entry.
     * Otherwise, returns Null.
     *
     * @param key
     * @return value found
     */
    public V get(K key) {
        int bucket = Math.abs(Objects.hashCode(key)) % 10;
        V value = null;
        if (buckets[bucket] == null) {
            throw new IllegalArgumentException();
        } else {
            Entry<K, V> current = buckets[bucket];
            do {
                if (current.key.equals(key)) {
                    value = current.value;
                }
                current = current.next;
            } while (current != null);
        }
        return value;
    }

    /**
     * Removes the entry: checks each entry and compares it with the key. If key found, returns the value of the entry.
     * Otherwise, returns Null.
     * Removes the found entry via rewriting the links.
     *
     * @param key
     * @return value removed
     */
    public V remove(K key) {
        V value = null;
        int bucket = Math.abs(Objects.hashCode(key)) % 10;
        Entry<K, V> current = buckets[bucket];
        if (current.key.equals(key)) {
            value = current.value;
            current = current.next;
            buckets[bucket] = current;
            size--;
        } else {
            while (current.next != null) {
                if (current.next.key.equals(key)) {
                    value = current.next.value;
                    current.next = current.next.next;
                    size--;
                }
                current = current.next;
            }
        }
        return value;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",");
        for (Entry<K, V> bucket : buckets) {
            if (bucket != null) {
                Entry<K, V> current = bucket;
                sj.add(current.toString());
                while (current.next != null) {
                    sj.add(current.next.toString());
                    current = current.next;
                }
            }
        }
        return "{" + sj + "}";
    }

    /**
     * @return the size of the map
     */
    public int size() {
        return size;
    }

    /**
     * Method clears the map
     */
    public void clear() {
        size = 0;
        buckets = (Entry<K, V>[]) new Entry[CAPACITY];
    }
}
