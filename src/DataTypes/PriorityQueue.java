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
import java.util.NoSuchElementException;

public class PriorityQueue<T extends Comparable<T>> implements Iterable<T> {
    private ArrayList<T> heap;

    public ArrayList<T> getHeap() {
        return heap;
    }

    public void setHeap(ArrayList<T> heap) {
        this.heap = heap;
    }

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    public void insert(T item) {
        heap.add(item);
        swim(heap.size() - 1);
    }

    public T delete() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty.");
        }
        T max = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        sink(0);
        return max;
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int size() {
        return heap.size();
    }

    private void swim(int k) {
        while (k > 0 && less(parent(k), k)) {
            swap(parent(k), k);
            k = parent(k);
        }
    }

    private void sink(int k) {
        while (leftChild(k) < heap.size()) {
            int largerChild = leftChild(k);
            if (rightChild(k) < heap.size() && less(largerChild, rightChild(k))) {
                largerChild = rightChild(k);
            }
            if (!less(k, largerChild)) {
                break;
            }
            swap(k, largerChild);
            k = largerChild;
        }
    }

    private boolean less(int i, int j) {
        return heap.get(i).compareTo(heap.get(j)) < 0;
    }

    private void swap(int i, int j) {
        T swap = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, swap);
    }

    private int parent(int k) {
        return (k - 1) / 2;
    }

    private int leftChild(int k) {
        return 2 * k + 1;
    }

    private int rightChild(int k) {
        return 2 * k + 2;
    }

    @Override
    public Iterator<T> iterator() {
        return new PriorityQueueIterator();
    }

    private class PriorityQueueIterator implements Iterator<T> {
        public PriorityQueue<T> getCopy() {
            return copy;
        }

        public void setCopy(PriorityQueue<T> copy) {
            this.copy = copy;
        }

        private PriorityQueue<T> copy;

        public PriorityQueueIterator() {
            copy = new PriorityQueue<>();
            for (T item : heap) {
                copy.insert(item);
            }
        }

        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return copy.delete();
        }
    }
}

