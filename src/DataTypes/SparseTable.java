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

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SparseTable<T extends Comparable<T>> implements Iterable<T> {
    private Object[] data;

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }

    public Comparable[][] getSparseTable() {
        return sparseTable;
    }

    public void setSparseTable(Comparable[][] sparseTable) {
        this.sparseTable = sparseTable;
    }

    public int[] getLogTable() {
        return logTable;
    }

    public void setLogTable(int[] logTable) {
        this.logTable = logTable;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private Comparable[][] sparseTable;
    private int[] logTable;
    private int size;

    public SparseTable(T[] dataArray) {
        buildSparseTable(dataArray);
    }

    private void buildSparseTable(T[] dataArray) {
        this.data = dataArray;
        this.size = dataArray.length;
        logTable = new int[size + 1];
        for (int i = 2; i <= size; i++) {
            logTable[i] = logTable[i >> 1] + 1;
        }

        int maxLog = logTable[size];
        sparseTable = new Comparable[maxLog + 1][size];

        for (int i = 0; i < size; i++) {
            sparseTable[0][i] = dataArray[i];
        }

        for (int k = 1; (1 << k) < size; k++) {
            for (int i = 0; i + (1 << k) <= size; i++) {
                sparseTable[k][i] = min(sparseTable[k - 1][i], sparseTable[k - 1][i + (1 << (k - 1))]);
            }
        }
    }

    public T query(int left, int right) {
        int log = logTable[right - left];
        return min(sparseTable[log][left], sparseTable[log][right - (1 << log)]);
    }

    public void update(int index, T newValue) {
        data[index] = newValue;
        buildSparseTable((T[]) data);
    }

    @SuppressWarnings("unchecked")
    private T min(Comparable a, Comparable b) {
        return a.compareTo(b) <= 0 ? (T) a : (T) b;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) data[currentIndex++];
            }
        };
    }
}

