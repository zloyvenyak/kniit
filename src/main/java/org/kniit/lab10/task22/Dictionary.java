package org.kniit.lab10.task22;

import java.util.ArrayList;
import java.util.List;

public class Dictionary<K, V> {
    private List<Entry<K, V>> entries;

    public Dictionary() {
        this.entries = new ArrayList<>();
    }

    public void put(K key, V value) {
        for (Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        entries.add(new Entry<>(key, value));
    }

    public V get(K key) {
        for (Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public void remove(K key) {
        entries.removeIf(entry -> entry.getKey().equals(key));
    }
}
