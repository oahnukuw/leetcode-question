package leetcode.editor.ds;

import java.util.LinkedList;
import java.util.List;


public class ChainHashMap<K, V> {


    private static class KVNode<K, V> {
        K key;
        V value;

        public KVNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

//    table, storing the linkedList
private LinkedList<KVNode<K, V>>[] table;

    //    Current size of key-value nodes
    private int size;

    private static final int DEFAULT_INIT_CAPACITY = 4;

    //    Indicate if expand the table capacity
    private static final float DEFAULT_LOAD_FACTOR = 0.75F;

    public ChainHashMap() {
        this(DEFAULT_INIT_CAPACITY);
    }

    public ChainHashMap(int initCapacity) {
        this.size = 0;
        initCapacity = Math.max(1, initCapacity);
        table = (LinkedList<KVNode<K, V>>[]) new LinkedList[initCapacity];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
    }

    //    add if key is null, or update the value
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("key is null while putting");
        }
        LinkedList<KVNode<K, V>> list = table[hash(key)];
        for (KVNode<K, V> kvNode : list) {
            if (kvNode.key.equals(key)) {
                kvNode.value = value;
                return;
            }
        }

        list.add(new KVNode<>(key, value));
        size++;

        if ((float) (size / table.length) > DEFAULT_LOAD_FACTOR) {
            resize(table.length * 2);
        }
    }

    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key is null while removing");
        }
        LinkedList<KVNode<K, V>> list = table[hash(key)];
        for (KVNode<K, V> kvNode : list) {
            if (kvNode.key.equals(key)) {
                list.remove(kvNode);
                size--;

                if (size <= table.length / 8) {
                    resize(table.length / 4);
                }
                return kvNode.value;
            }
        }
        return null;
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key is null while removing");
        }
        LinkedList<KVNode<K, V>> list = table[hash(key)];
        for (KVNode<K, V> kvNode : list) {
            if (kvNode.key.equals(key)) {
                return kvNode.value;
            }

        }
        return null;
    }

    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }
        LinkedList<KVNode<K, V>> list = table[hash(key)];
        for (KVNode<K, V> kvNode : list) {
            if (kvNode.key.equals(key)) {
                return true;
            }

        }
        return false;
    }

    public List<K> keys() {
        LinkedList<K> keys = new LinkedList<>();
        for (LinkedList<KVNode<K, V>> kvNodes : table) {
            for (KVNode<K, V> kvNode : kvNodes) {
                keys.add(kvNode.key);
            }
        }
        return keys;
    }

    public int size() {
        return this.size;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % table.length;
    }

    private void resize(int newCap) {
        ChainHashMap<K, V> chainHashMap = new ChainHashMap<>(newCap);
        for (LinkedList<KVNode<K, V>> list : table) {
            for (KVNode<K, V> node : list) {
                chainHashMap.put(node.key, node.value);
            }
        }
        this.table = chainHashMap.table;
    }

    public static void main(String[] args) {
        ChainHashMap<String, Integer> map = new ChainHashMap<>();
        map.put(String.valueOf(1), 1);
        map.put(String.valueOf(2), 2);
        System.out.println(map.get("1"));
        System.out.println(map.get("2"));
        map.put("1", 100);
        System.out.println(map.get("1"));
        System.out.println(map.keys());
        map.put("11", 200);
        System.out.println(map.keys());
        map.remove("2");
        System.out.println(map.get("2"));
        System.out.println(map.keys());
        System.out.println(map.remove("1"));
        System.out.println(map.remove("2"));
        System.out.println(map.remove("11"));
        System.out.println(map.get("1"));
        System.out.println(map.keys());
        System.out.println(map.size());
    }
}
