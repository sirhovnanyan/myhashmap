package hashmap;

public interface MyMap<K, V> {

    int size();

    boolean isEmpty();

    boolean containsKey(K key);

    boolean containsValue(Object value);

    V get(Object key);

    V put(K key, V value);

    boolean remove(K key);

    int indexHash(Object key);
}
