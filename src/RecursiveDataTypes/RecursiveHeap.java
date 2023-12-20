/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Wed, 20th December 2023, 17:00
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, collaborators and terms of use,
 * please visit the GitHub repository.
 */
package RecursiveDataTypes;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class RecursiveHeap {
    private ArrayList<Integer> heap;

    public RecursiveHeap() {
        this.heap = new ArrayList<>();
    }

    public ArrayList<Integer> getHeap() {
        return heap;
    }

    public void setHeap(ArrayList<Integer> heap) {
        this.heap = heap;
    }

    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    private void heapifyUp(int index) {
        if (index == 0) return; // Base case: root of the heap

        int parentIndex = (index - 1) / 2;
        if (heap.get(index) > heap.get(parentIndex)) {
            swap(index, parentIndex);
            heapifyUp(parentIndex); // Recursive call
        }
    }

    public int remove() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }

        int removedValue = heap.get(0);
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);
        heapifyDown(0);
        return removedValue;
    }

    private void heapifyDown(int index) {
        int largest = index;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex) > heap.get(largest)) {
            largest = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(largest)) {
            largest = rightChildIndex;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest); // Recursive call
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public int peek() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}

