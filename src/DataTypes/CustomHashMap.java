/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Mon, 18th December 2023, 18:15
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, collaborators and terms of use,
 * please visit the GitHub repository.
 */
package DataTypes;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class CustomHashMap<K, V> implements Iterable<V> {
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] table;
    private int size;

    public CustomHashMap() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public CustomHashMap(int capacity) {
        table = new LinkedList[capacity];
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = table[index];
        if (bucket != null) {
            for (Entry<K, V> entry : bucket) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = table[index];
        if (bucket != null) {
            Iterator<Entry<K, V>> iterator = bucket.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().key.equals(key)) {
                    iterator.remove();
                    size--;
                    break;
                }
            }
        }
    }

    public int size() {
        return size;
    }

    private int getIndex(K key) {
        return key.hashCode() % table.length;
    }

    @Override
    public Iterator<V> iterator() {
        return new GenericHashMapIterator();
    }

    private class GenericHashMapIterator implements Iterator<V> {
        private int currentBucket;
        private Iterator<Entry<K, V>> bucketIterator;

        public GenericHashMapIterator() {
            moveToNextBucket();
        }

        @Override
        public boolean hasNext() {
            if (bucketIterator != null && bucketIterator.hasNext()) {
                return true;
            }
            moveToNextBucket();
            return bucketIterator != null && bucketIterator.hasNext();
        }

        @Override
        public V next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return bucketIterator.next().value;
        }

        private void moveToNextBucket() {
            while (currentBucket < table.length && (table[currentBucket] == null || !table[currentBucket].iterator().hasNext())) {
                currentBucket++;
            }
            if (currentBucket < table.length) {
                bucketIterator = table[currentBucket].iterator();
            } else {
                bucketIterator = null;
            }
        }
    }
}
