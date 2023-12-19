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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MaxHeap<T extends Comparable<T>> implements Iterable<T> {
    public ArrayList<T> getHeap() {
        return heap;
    }

    public void setHeap(ArrayList<T> heap) {
        this.heap = heap;
    }

    private ArrayList<T> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    public void insert(T value) {
        heap.add(value);
        int currentIndex = heap.size() - 1;
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (heap.get(currentIndex).compareTo(heap.get(parentIndex)) > 0) {
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    public T delete() {
        if (heap.size() == 0) {
            throw new NoSuchElementException("Heap is empty");
        }
        T removedValue = heap.get(0);
        T lastValue = heap.remove(heap.size() - 1);
        if (heap.size() > 0) {
            heap.set(0, lastValue);
            heapify(0);
        }
        return removedValue;
    }

    private void heapify(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int largestIndex = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(largestIndex)) > 0) {
            largestIndex = leftChildIndex;
        }
        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(largestIndex)) > 0) {
            largestIndex = rightChildIndex;
        }
        if (largestIndex != index) {
            swap(index, largestIndex);
            heapify(largestIndex);
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<T> {
        public int getCurrentIndex() {
            return currentIndex;
        }

        public void setCurrentIndex(int currentIndex) {
            this.currentIndex = currentIndex;
        }

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < heap.size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return heap.get(currentIndex++);
        }
    }

    // Additional utility methods like size, peek, etc., can be added here if needed
}

