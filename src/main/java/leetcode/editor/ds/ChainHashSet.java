package leetcode.editor.ds;

public class ChainHashSet<K> {

    private final ChainHashMap<K, Object> map;

    private static final Object PRESENT = new Object();

    private static final int DEFAULT_INIT_CAPACITY = 4;

    public ChainHashSet() {
        this(DEFAULT_INIT_CAPACITY);
    }

    public ChainHashSet(int initCapacity) {
        map = new ChainHashMap<>(initCapacity);
    }

    public void put(K key) {
        map.put(key, PRESENT);
    }

    public void remove(K key) {
        map.remove(key);
    }

    public boolean contain(K key) {
        return map.containsKey(key);
    }


}
