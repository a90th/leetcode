package to.geekbang;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Lesson42_LRUCache<K, V> {

    private int capacity;
    private Map<K, CacheNode<K, V>> items;
    private CacheNode<K, V> head;
    private CacheNode<K, V> tail;

    public Lesson42_LRUCache(int capacity) {
        this.capacity = capacity;
        items = new HashMap<K, CacheNode<K, V>>(capacity);
        head = new CacheNode<K, V>();
        tail = new CacheNode<K, V>();
        head.next = tail;
        tail.pre = head;
    }

    public V get(K key) {
        CacheNode<K, V> tNode = items.get(key);
        if (null == tNode) return null;
        remove(tNode);
        addHead(tNode);
        return tNode.value;
    }

    public void put(K key, V value) {
        CacheNode targetNode = items.get(key);
        if (null == targetNode) {
            CacheNode<K, V> nNode = new CacheNode<>();
            nNode.value = value;
            nNode.key = key;
            if (items.size() < capacity) {
                addHead(nNode);
                items.put(key, nNode);
            } else {
                CacheNode dNode = tail.pre;
                items.remove(dNode.key);
                items.put(key, nNode);
                remove(dNode);
                addHead(nNode);
            }
        } else {
            targetNode.value = value;
            remove(targetNode);
            addHead(targetNode);
        }
    }

    private void remove(CacheNode<K, V> tNode) {
        tNode.pre.next = tNode.next;
        tNode.next.pre = tNode.pre;
    }

    private void addHead(CacheNode<K, V> tNode) {
        tNode.next = head.next;
        tNode.pre = head;
        head.next.pre = tNode;
        head.next = tNode;
    }

    public static class UnitTest {
        @Test
        public void test() {

            Lesson42_LRUCache lruCache = new Lesson42_LRUCache<String, Integer>(3);
            lruCache.put("A", 10);
            lruCache.put("B", 20);
            lruCache.put("C", 30);
            lruCache.put("D", 40);
            assert null == lruCache.get("A");
            assert lruCache.get("B").equals(20);
            lruCache.put("E", 50);
            assert null == lruCache.get("C");

        }
    }
}

class CacheNode<K, V> {
    K key;
    V value;
    CacheNode pre;
    CacheNode next;
}


