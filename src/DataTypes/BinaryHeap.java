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

public class BinaryHeap<T extends Comparable<T>> implements Iterable<T> {
    private ArrayList<T> heap;
    private boolean isMinHeap;

    public BinaryHeap(boolean isMinHeap) {
        this.heap = new ArrayList<>();
        this.isMinHeap = isMinHeap;
    }

    public void insert(T value) {
        heap.add(value);
        siftUp(heap.size() - 1);
    }

    public T delete() throws NoSuchElementException {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }

        T removedValue = heap.get(0);
        T lastValue = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastValue);
            siftDown(0);
        }

        return removedValue;
    }

    public ArrayList<T> getHeap() {
        return heap;
    }

    public boolean isMinHeap() {
        return isMinHeap;
    }

    private void siftUp(int index) {
        T value = heap.get(index);
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            T parentValue = heap.get(parentIndex);
            if (compare(parentValue, value) <= 0) {
                break;
            }
            heap.set(index, parentValue);
            index = parentIndex;
        }
        heap.set(index, value);
    }

    private void siftDown(int index) {
        T value = heap.get(index);
        int heapSize = heap.size();
        while (index < heapSize) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int childIndex = -1;

            if (leftChildIndex < heapSize) {
                T leftChildValue = heap.get(leftChildIndex);
                if (rightChildIndex < heapSize) {
                    T rightChildValue = heap.get(rightChildIndex);
                    childIndex = compare(leftChildValue, rightChildValue) <= 0 ? leftChildIndex : rightChildIndex;
                } else {
                    childIndex = leftChildIndex;
                }
            }

            if (childIndex == -1 || compare(value, heap.get(childIndex)) <= 0) {
                break;
            }

            heap.set(index, heap.get(childIndex));
            index = childIndex;
        }
        heap.set(index, value);
    }

    private int compare(T o1, T o2) {
        return isMinHeap ? o1.compareTo(o2) : -o1.compareTo(o2);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
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
        };
    }

    public void setHeap(ArrayList<T> heap) {
        this.heap = heap;
    }

    public void setMinHeap(boolean minHeap) {
        isMinHeap = minHeap;
    }
}

