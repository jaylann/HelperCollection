package DataTypes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class GenericHashTable<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private ArrayList<LinkedList<Entry<K, V>>> bucketArray;
    private int size;

    public GenericHashTable() {
        bucketArray = new ArrayList<>();
        size = 0;
        // Initialize buckets
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            bucketArray.add(new LinkedList<>());
        }
    }

    public int size() { return size; }
    public boolean isEmpty() { return size() == 0; }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % bucketArray.size();
        return index < 0 ? index * -1 : index;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = bucketArray.get(bucketIndex);

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void add(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = bucketArray.get(bucketIndex);

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        size++;
        bucket.add(new Entry<>(key, value));

        // Optional: resize the hash table if load factor goes beyond a threshold
    }

    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = bucketArray.get(bucketIndex);
        Entry<K, V> removeEntry = null;

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                removeEntry = entry;
                break;
            }
        }

        if (removeEntry != null) {
            bucket.remove(removeEntry);
            size--;
            return removeEntry.value;
        }

        return null;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new HashTableIterator();
    }

    private class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private class HashTableIterator implements Iterator<Entry<K, V>> {
        private int currentBucket;
        private Iterator<Entry<K, V>> bucketIterator;

        public HashTableIterator() {
            currentBucket = 0;
            bucketIterator = bucketArray.get(0).iterator();
        }

        @Override
        public boolean hasNext() {
            if (bucketIterator.hasNext()) {
                return true;
            }
            for (int i = currentBucket + 1; i < bucketArray.size(); i++) {
                if (!bucketArray.get(i).isEmpty()) {
                    currentBucket = i;
                    bucketIterator = bucketArray.get(i).iterator();
                    return bucketIterator.hasNext();
                }
            }
            return false;
        }

        @Override
        public Entry<K, V> next() {
            if (!bucketIterator.hasNext()) {
                for (int i = currentBucket + 1; i < bucketArray.size(); i++) {
                    if (!bucketArray.get(i).isEmpty()) {
                        currentBucket = i;
                        bucketIterator = bucketArray.get(i).iterator();
                        break;
                    }
                }
            }
            return bucketIterator.next();
        }
    }
}
