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

import java.util.*;

public class DisjointSet<T> implements Iterable<T> {
    private Map<T, T> parent = new HashMap<>();
    private Map<T, Integer> rank = new HashMap<>();

    public Map<T, T> getParent() {
        return parent;
    }

    public void setParent(Map<T, T> parent) {
        this.parent = parent;
    }

    public Map<T, Integer> getRank() {
        return rank;
    }

    public void setRank(Map<T, Integer> rank) {
        this.rank = rank;
    }

    public void insert(T item) {
        if (!parent.containsKey(item)) {
            parent.put(item, item);
            rank.put(item, 0);
        }
    }

    public void delete(T item) {
        // This operation is complex in a union-find structure and not typically supported
        // This method assumes the item is a single element set and not part of a larger set
        if (parent.containsKey(item) && parent.get(item).equals(item)) {
            parent.remove(item);
            rank.remove(item);
        }
    }

    public T find(T item) {
        if (!parent.containsKey(item)) {
            throw new NoSuchElementException("Item not found in Disjoint Set");
        }
        if (item.equals(parent.get(item))) {
            return item;
        }
        T root = find(parent.get(item));
        parent.put(item, root); // Path compression
        return root;
    }

    public void union(T x, T y) {
        T rootX = find(x);
        T rootY = find(y);

        if (rootX.equals(rootY)) {
            return;
        }

        if (rank.get(rootX) < rank.get(rootY)) {
            parent.put(rootX, rootY);
        } else if (rank.get(rootX) > rank.get(rootY)) {
            parent.put(rootY, rootX);
        } else {
            parent.put(rootY, rootX);
            rank.put(rootX, rank.get(rootX) + 1);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new DisjointSetIterator();
    }

    private class DisjointSetIterator implements Iterator<T> {
        public Iterator<T> getIt() {
            return it;
        }

        public void setIt(Iterator<T> it) {
            this.it = it;
        }

        private Iterator<T> it = parent.keySet().iterator();

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public T next() {
            return it.next();
        }
    }
}

