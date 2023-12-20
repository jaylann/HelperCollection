/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Mon, 18th December 2023, 18:15
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, collaborators and terms of use,
 * please visit the GitHub repository.
 */
package RecursiveDataTypes;

import java.util.HashMap;
import java.util.Map;

public class RecursiveHashMap {
    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    private Map<String, Object> map;

    public RecursiveHashMap() {
        this.map = new HashMap<>();
    }

    // Method to put a value
    public void put(String key, Object value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        map.put(key, value);
    }

    // Method to get a value
    public Object get(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException("Key does not exist");
        }
        return map.get(key);
    }

    // Method to check if a key exists
    public boolean containsKey(String key) {
        return map.containsKey(key);
    }

    // Method to create a nested RecursiveHashMap
    public RecursiveHashMap createNestedMap(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        RecursiveHashMap nestedMap = new RecursiveHashMap();
        put(key, nestedMap);
        return nestedMap;
    }

    // Method to get a nested RecursiveHashMap
    public RecursiveHashMap getNestedMap(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (!map.containsKey(key) || !(map.get(key) instanceof RecursiveHashMap)) {
            throw new IllegalArgumentException("No nested RecursiveHashMap exists for this key");
        }
        return (RecursiveHashMap) map.get(key);
    }

    // Optional: Override toString for better visualization
    @Override
    public String toString() {
        return map.toString();
    }
}

