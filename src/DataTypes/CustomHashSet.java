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

public class CustomHashSet<T> implements Iterable<T> {
    private static final int INITIAL_CAPACITY = 16;

    public LinkedList<T>[] getBuckets() {
        return buckets;
    }

    public void setBuckets(LinkedList<T>[] buckets) {
        this.buckets = buckets;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private LinkedList<T>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public CustomHashSet() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        size = 0;
    }

    public boolean add(T element) {
        if (contains(element)) {
            return false;
        }

        int index = getIndex(element);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        buckets[index].add(element);
        size++;
        return true;
    }

    public boolean remove(T element) {
        int index = getIndex(element);
        LinkedList<T> bucket = buckets[index];

        if (bucket != null && bucket.remove(element)) {
            size--;
            return true;
        }

        return false;
    }

    public boolean contains(T element) {
        int index = getIndex(element);
        LinkedList<T> bucket = buckets[index];

        if (bucket != null) {
            return bucket.contains(element);
        }

        return false;
    }

    public int size() {
        return size;
    }

    private int getIndex(T element) {
        return Math.abs(element.hashCode()) % buckets.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new HashSetIterator();
    }

    private class HashSetIterator implements Iterator<T> {
        private int currentBucket;
        private Iterator<T> bucketIterator;

        public HashSetIterator() {
            currentBucket = -1;
            moveToNextBucket();
        }

        @Override
        public boolean hasNext() {
            if (bucketIterator == null) {
                return false;
            }
            if (bucketIterator.hasNext()) {
                return true;
            }

            moveToNextBucket();
            return bucketIterator != null && bucketIterator.hasNext();
        }

        @Override
        public T next() {
            if (hasNext()) {
                return bucketIterator.next();
            }
            return null;
        }

        private void moveToNextBucket() {
            currentBucket++;
            while (currentBucket < buckets.length && (buckets[currentBucket] == null || !buckets[currentBucket].iterator().hasNext())) {
                currentBucket++;
            }
            if (currentBucket < buckets.length) {
                bucketIterator = buckets[currentBucket].iterator();
            } else {
                bucketIterator = null;
            }
        }
    }
}

