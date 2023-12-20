/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Wed, 20th December 2023, 17:00
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, collaborators and terms of use,
 * please visit the GitHub repository.
 */
package DataTypes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class GenericHashTable<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private ArrayList<LinkedList<Entry<K, V>>> bucketArray;

    public ArrayList<LinkedList<Entry<K, V>>> getBucketArray() {
        return bucketArray;
    }

    public void setBucketArray(ArrayList<LinkedList<Entry<K, V>>> bucketArray) {
        this.bucketArray = bucketArray;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

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

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private class HashTableIterator implements Iterator<Entry<K, V>> {
        private int currentBucket;

        public int getCurrentBucket() {
            return currentBucket;
        }

        public void setCurrentBucket(int currentBucket) {
            this.currentBucket = currentBucket;
        }

        public Iterator<Entry<K, V>> getBucketIterator() {
            return bucketIterator;
        }

        public void setBucketIterator(Iterator<Entry<K, V>> bucketIterator) {
            this.bucketIterator = bucketIterator;
        }

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

