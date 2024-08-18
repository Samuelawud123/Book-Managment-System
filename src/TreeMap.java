import java.util.Arrays;

/**
 * Custom implementation of a TreeMap.
 * This class manages a collection of key-value pairs, organized in a binary search tree structure.
 * The keys must be comparable to maintain the tree's order.
 *
 * @param <K> The type of keys maintained by this map, must be Comparable.
 * @param <V> The type of mapped values.
 */
public class TreeMap<K extends Comparable<K>, V> implements TreeMapInterface<K, V> {
    private TreeMapNode<K, V> root;
    private int size;

    /**
     * Constructs an empty TreeMap.
     */
    public TreeMap() {
        root = null;
        size = 0;
    }

    /**
     * Returns the number of key-value pairs in the tree.
     *
     * @return the size of the TreeMap.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Clears all key-value pairs from the tree.
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Retrieves the value associated with a given key.
     *
     * @param key The key whose associated value is to be returned.
     * @return the value associated with the specified key, or null if the key does not exist.
     * @throws IllegalArgumentException if the key is null.
     */
    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        return get(root, key);
    }

    /**
     * Recursive helper method to find the value associated with a given key.
     *
     * @param root The starting node of the subtree.
     * @param key  The key being searched for.
     * @return the value associated with the specified key, or null if the key does not exist.
     */
    private V get(TreeMapNode<K, V> root, K key) {
        if (root == null) {
            return null;
        } else {
            int compare = key.compareTo(root.key);
            if (compare == 0) {
                return root.value;
            } else if (compare < 0) {
                return get(root.left, key);
            } else {
                return get(root.right, key);
            }
        }
    }

    /**
     * Inserts a key-value pair into the TreeMap. If the tree previously contained a mapping for the key,
     * the old value is replaced by the specified value.
     *
     * @param key   The key with which the specified value is to be associated.
     * @param value The value to be associated with the specified key.
     * @throws IllegalArgumentException if the key is null.
     */
    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        root = put(root, key, value);
    }

    /**
     * Recursive helper method to insert a key-value pair into the TreeMap.
     *
     * @param root  The starting node of the subtree.
     * @param key   The key to insert.
     * @param value The value associated with the key.
     * @return The root of the modified subtree.
     */
    private TreeMapNode<K, V> put(TreeMapNode<K, V> root, K key, V value) {
        if (root == null) {
            size++;
            return new TreeMapNode<>(key, value);
        } else {
            int compare = key.compareTo(root.key);
            if (compare == 0) {
                root.value = value; // Update value if key exists
            } else if (compare < 0) {
                root.left = put(root.left, key, value);
            } else {
                root.right = put(root.right, key, value);
            }
            return root;
        }
    }

    /**
     * Checks if the TreeMap contains a specified key.
     *
     * @param key The key whose presence in this map is to be tested.
     * @return true if this map contains a mapping for the specified key.
     */
    @Override
    public boolean containsKey(K key) {

        return get(key) != null;
    }

/**
 * Converts the keys of the TreeMap into an array.
 * If the provided array is large enough to hold the keys, it is used.
 * Otherwise, a new array is created.
 *
 * @param array The array into which the elements of the TreeMap are to be stored.
 * @return An array containing all keys in the TreeMap, sorted.
 */
@Override
public K[] toKeyArray(K[] array) {
    int index = fillInOrder(root, array, 0);
    if (index < array.length) {
        array[index] = null; // Signaling the end of copied data
    }
    return array.length > size ? Arrays.copyOf(array, size) : array;
}

    /**
     * Recursive helper method to fill an array with the keys of the TreeMap in order.
     *
     * @param node  The current node in the tree.
     * @param array The array to fill with keys.
     * @param index The current index in the array.
     * @return The next index to fill in the array.
     */
    private int fillInOrder(TreeMapNode<K, V> node, K[] array, int index) {
        if (node != null) {
            index = fillInOrder(node.left, array, index);
            array[index++] = node.key;
            index = fillInOrder(node.right, array, index);
        }
        return index;
    }

    /**
     * Inner class representing a node in the TreeMap.
     * Each node contains a key, a value, and references to the left and right child nodes.
     *
     * @param <K> The type of keys maintained by the node.
     * @param <V> The type of values maintained by the node.
     */
    private static class TreeMapNode<K, V> {
        public K key;
        public V value;
        public TreeMapNode<K, V> left;
        public TreeMapNode<K, V> right;

        /**
         * Constructs a TreeMapNode with the given key and value.
         *
         * @param key   The key associated with this node.
         * @param value The value associated with this node.
         */
        public TreeMapNode(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }
}
