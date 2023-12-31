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

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SuffixTree {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    private class Node {
        Map<Character, Node> children = new HashMap<>();
        int startIndex;

        public Map<Character, Node> getChildren() {
            return children;
        }

        public void setChildren(Map<Character, Node> children) {
            this.children = children;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        public Integer getEndIndex() {
            return endIndex;
        }

        public void setEndIndex(Integer endIndex) {
            this.endIndex = endIndex;
        }

        Integer endIndex;

        Node(int start, Integer end) {
            this.startIndex = start;
            this.endIndex = end;
        }
    }

    private String text;
    private Node root;

    public SuffixTree(String text) {
        this.text = text;
        this.root = new Node(0, null);
        for (int i = 0; i < text.length(); i++) {
            insert(i);
        }
    }

    private void insert(int index) {
        Node current = root;
        for (int i = index; i < text.length(); i++) {
            char c = text.charAt(i);
            if (!current.children.containsKey(c)) {
                current.children.put(c, new Node(i, text.length()));
                break;
            }
            current = current.children.get(c);
        }
    }

    public void delete(String suffix) {
        if (suffix == null || suffix.isEmpty()) {
            return;
        }

        Node current = root;
        for (char c : suffix.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return;
            }
            current = current.children.get(c);
        }

        if (current != root) {
            int start = current.startIndex;
            current = root;
            for (int i = start; i < text.length() && current != null; i++) {
                current.children.remove(text.charAt(i));
                current = current.children.get(text.charAt(i));
            }
        }
    }

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            Queue<Node> queue = new LinkedList<>();
            String currentSuffix = "";

            {
                queue.add(root);
            }

            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public String next() {
                while (!queue.isEmpty()) {
                    Node node = queue.poll();
                    for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
                        char c = entry.getKey();
                        Node child = entry.getValue();
                        currentSuffix = text.substring(child.startIndex, child.endIndex);
                        queue.add(child);
                        return currentSuffix;
                    }
                }
                return null;
            }
        };
    }
}
