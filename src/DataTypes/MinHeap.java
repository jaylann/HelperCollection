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

import java.util.*;

public class MinHeap<T extends Comparable<T>> implements Iterable<T> {
    private List<T> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    public void insert(T element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    public T delete() {
        if (heap.size() == 0) {
            throw new NoSuchElementException("Heap is empty");
        }

        T removedItem = heap.get(0);
        T lastItem = heap.remove(heap.size() - 1);

        if (heap.size() > 0) {
            heap.set(0, lastItem);
            heapifyDown(0);
        }

        return removedItem;
    }

    private void heapifyUp(int index) {
        T temp = heap.get(index);
        while (index > 0 && temp.compareTo(heap.get(parentIndex(index))) < 0) {
            heap.set(index, heap.get(parentIndex(index)));
            index = parentIndex(index);
        }
        heap.set(index, temp);
    }

    private void heapifyDown(int index) {
        int childIndex;
        T temp = heap.get(index);
        while (kthChild(index, 1) < heap.size()) {
            childIndex = minChild(index);
            if (heap.get(childIndex).compareTo(temp) < 0) {
                heap.set(index, heap.get(childIndex));
            } else {
                break;
            }
            index = childIndex;
        }
        heap.set(index, temp);
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private int kthChild(int i, int k) {
        return 2 * i + k;
    }

    private int minChild(int i) {
        int leftChild = kthChild(i, 1);
        int rightChild = kthChild(i, 2);

        return (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(leftChild)) < 0) ? rightChild : leftChild;
    }

    public Iterator<T> iterator() {
        return new HeapIterator();
    }

    public List<T> getHeap() {
        return heap;
    }

    public void setHeap(List<T> heap) {
        this.heap = heap;
    }

    private class HeapIterator implements Iterator<T> {
        private MinHeap<T> copy;

        public MinHeap<T> getCopy() {
            return copy;
        }

        public void setCopy(MinHeap<T> copy) {
            this.copy = copy;
        }

        public HeapIterator() {
            copy = new MinHeap<>();
            for (T item : heap) {
                copy.insert(item);
            }
        }

        public boolean hasNext() {
            return !copy.heap.isEmpty();
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return copy.delete();
        }
    }

    // Additional methods for heap size and checking if it's empty
    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }
}

