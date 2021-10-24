package hashmap;

import java.util.List;

public interface MyMap<K, V> {

    int size();

    boolean isEmpty();

    boolean containsKey(K key);

    boolean containsValue(Object value);

    V get(Object key);

    V put(K key, V value);

    boolean remove(K key);

    int indexHash(Object key);

    Iterator<K, V> iterator();

    List<MyHashMap<K, V>.Entry<K, V>> entryList();

    interface MyEntry<K, V> {
        boolean equals(Object o);

        int hashCode();

        K getKey();

        V getValue();
    }

    interface Iterator<K, V> {
        boolean hasNext();

        MyEntry<K, V> next();
    }
}
