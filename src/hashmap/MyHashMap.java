package hashmap;

import java.util.Objects;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private static final int DEFAULT_SIZE = 16;
    private int size = 0;
    private Entry<K, V>[] buckets;

    public MyHashMap() {
        buckets = new Entry[DEFAULT_SIZE];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexHash(Object key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % buckets.length);
    }

    @Override
    public boolean containsKey(K key) {
        int index = indexHash(key);
        Entry<K, V> entry = buckets[index];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return true;
            }
            entry = entry.next();
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        V val;
        if (buckets != null && size > 0) {
            for (Entry<K, V> ent : buckets) {
                while(ent!=null) {
                    if ((val = ent.value) == value || (value != null && value.equals(val))) {
                        return true;
                    }
                    ent=ent.next();
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        V value = null;
        int index = indexHash(key);
        Entry<K, V> entry = buckets[index];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                value = entry.getValue();
                break;
            }
            entry = entry.next();
        }
        return value;
    }

    @Override
    public V put(K key, V value) {
        int index = indexHash(key);
        Entry<K, V> newEntry = new Entry<>(key, value, null);
        if (buckets[index] == null) {
            buckets[index] = newEntry;
            size++;
        } else {
            Entry<K, V> prevNode = null;
            Entry<K, V> currNode = buckets[index];
            while (currNode != null) {
                if (currNode.getKey().equals(key)) {
                    currNode.setValue(value);
                    break;
                }
                prevNode = currNode;
                currNode = currNode.next();
            }
            if (prevNode != null) {
                prevNode.setNext(newEntry);
                size++;
            }
        }
        return value;
    }

    @Override
    public boolean remove(K key) {
        int index = indexHash(key);
        Entry<K, V> prev = null;
        Entry<K, V> removedEntry = buckets[index];
        while (removedEntry != null) {
            if (removedEntry.getKey().equals(key)) {
                if (prev == null) {
                    removedEntry = removedEntry.next();
                    buckets[index] = removedEntry;
                    size--;
                    return true;
                } else {
                    prev.setNext(removedEntry.next());
                    size--;
                    return true;
                }
            }
            prev = removedEntry;
            removedEntry = removedEntry.next();
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                Entry<K, V> currentNode = buckets[i];
                while (currentNode != null) {
                    System.out.print(currentNode.getKey() + " - " + currentNode.getValue() + "  ");
                    currentNode = currentNode.next();
                }
            }
        }
    }

    private class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Entry<K, V> next() {
            return next;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return Objects.equals(key, entry.key) && value.equals(entry.value) && Objects.equals(next, entry.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value, next);
        }
    }
}
