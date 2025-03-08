package leetcode.editor.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ArrayHashMap<K, V> {
    private static class KVNode<K, V> {
        K key;
        V value;

        public KVNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    //    store key-index
    private final HashMap<K, Integer> map = new HashMap<>();
    //    store nodes
    private final ArrayList<KVNode<K, V>> array = new ArrayList<>();

    private final Random random = new Random();

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }

        int index = map.get(key);
        return array.get(index).value;
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
//            update
            int index = map.get(key);
            array.get(index).value = value;
            return;
        }

//        new
        array.add(new KVNode<>(key, value));
        map.put(key, array.size() - 1);
    }

    //    O(1): Exchange the last element with the node to remove, then remove the last element
    public void remove(K key) {
        if (!map.containsKey(key)) {
            return;
        }

        int index = map.get(key);

        KVNode<K, V> lastNode = array.get(array.size() - 1);

        array.set(index, lastNode);
        map.put(lastNode.key, index);

        array.remove(array.size() - 1);
        map.remove(key);
    }

    public K randomKey() {
        int size = array.size();
        int index = random.nextInt(size);
        return array.get(index).key;

    }

    public int size() {
        return array.size();
    }

    public static void main(String[] args) {
        ArrayHashMap<Integer, Integer> map = new ArrayHashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);

        System.out.println(map.get(1)); // 1
        System.out.println(map.randomKey());

        map.remove(4);
        System.out.println(map.randomKey());
        System.out.println(map.randomKey());
    }
}
