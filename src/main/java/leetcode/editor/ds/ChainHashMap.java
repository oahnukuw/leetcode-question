package leetcode.editor.ds;

import java.util.LinkedList;
import java.util.List;


public class ChainHashMap<K, V> {


    private static class KVNode<K, V> {
        K key;
        V value;

        KVNode<K, V> prev, next;

        public KVNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final KVNode<K, V> head, tail;

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

//        Initialize the doubly linkedList for recording the put sequence
        this.head = new KVNode<>(null, null);
        this.tail = new KVNode<>(null, null);
        this.head.next = this.tail;
        this.tail.prev = this.head;

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
        KVNode<K, V> node = new KVNode<>(key, value);
        list.add(node);
        addLastNode(node);
        size++;

        if ((float) (size / table.length) > DEFAULT_LOAD_FACTOR) {
            resize(table.length * 2);
        }
    }

    private void addLastNode(KVNode<K, V> node) {
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        node.next = tail;
    }

    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key is null while removing");
        }
        LinkedList<KVNode<K, V>> list = table[hash(key)];
        for (KVNode<K, V> node : list) {
            if (node.key.equals(key)) {
                list.remove(node);
//              remove the node from the sequence list
                removeNode(node);
                size--;

                if (size <= table.length / 8) {
                    resize(table.length / 4);
                }
                return node.value;
            }
        }
        return null;
    }

    private void removeNode(KVNode<K, V> node) {
        KVNode<K, V> prev = node.prev;
        KVNode<K, V> next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
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
        for (KVNode<K, V> node = head.next; node != tail; node = node.next) {
            keys.add(node.key);
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
        map.put("1", 100);
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
