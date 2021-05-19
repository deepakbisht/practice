package StackAndQueue;


import java.util.HashMap;
import java.util.Map;

/**
 * Created By Deepak Bisht on 28/05/20
 */
public class LRUCache {

    public static Node<Integer, Integer> head;
    public static Node<Integer, Integer> tail;

    public static int maxSize = 4;

    public static Map<Integer, Node<Integer, Integer>> lruCache = new HashMap<>();

    public static class Node<K, V> {
        public K key;
        public V value;
        Node<K, V> left;
        Node<K, V> right;

    }

    public static void set(int key, int value) {
        Node<Integer, Integer> node = new Node<>();
        node.key = key;
        node.value = value;
        if (lruCache.size() == maxSize) {
            remove();
        }
        if (lruCache.isEmpty()) {
            node.right = null;
            node.left = null;
            head = node;
            tail = node;
        } else {
            moveToFront(node);
        }
        lruCache.put(node.key, node);
    }

    public static void moveToFront(Node node) {
        //detach it
        if (node.left != null) {
            if (tail == node) {
                tail = node.left;
            }
            node.left.right = node.right;
            if (node.right != null) {
                node.right.left = node.left;
            }
        }

        node.right = head;
        head.left = node;
        node.left = null;
        head = node;
    }

    public static int get(int key) {
        moveToFront(lruCache.get(key));
        return lruCache.get(key).value;
    }

    public static void remove() {
        lruCache.remove(tail.key);
        if (tail == head) {
            tail = head = null;
        } else {
            tail = tail.left;
            tail.right = null;
        }
    }

    public static void main(String[] args) {
        set(1, 5);
        set(2, 6);
        set(3, 7);
        set(4, 8);
        set(5, 9);

        get(3);
        get(2);
        set(10, 11);
        System.out.println(lruCache);
    }

}
