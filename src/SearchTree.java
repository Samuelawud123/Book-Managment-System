/**
 * Class SearchTree represents a binary search tree (BST) structure for storing elements of type E.
 * The elements must implement the Comparable<E> interface to maintain order in the tree.
 *
 * @param <E> The type of elements in the tree. Must be a Comparable type.
 */
public class SearchTree<E extends Comparable<E>> {
    private SearchTreeNode<E> overallRoot; // Root of the overall tree

    /**
     * Constructs an empty search tree.
     */
    public SearchTree() {
        overallRoot = null;
    }

    /**
     * Adds a value to the tree while maintaining the binary search tree property.
     *
     * @param value The value to be added to the tree.
     * @throws IllegalArgumentException if the value is null.
     */
    public void add(E value) {
        if (value == null) {
            throw new IllegalArgumentException("Null entries are not allowed.");
        }
        overallRoot = add(overallRoot, value);
    }

    /**
     * Recursive helper method to add a value to the tree.
     *
     * @param root  The root of the current subtree.
     * @param value The value to add.
     * @return The root of the updated subtree.
     */
    private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
        if (root == null) {
            return new SearchTreeNode<>(value);
        } else if (value.compareTo(root.data) <= 0) {
            root.left = add(root.left, value);
        } else {
            root.right = add(root.right, value);
        }
        return root;
    }

    /**
     * Checks if a specific value is contained within the tree.
     *
     * @param value The value to be searched for.
     * @return true if the value is present in the tree, false otherwise.
     */
    public boolean contains(E value) {
        return contains(overallRoot, value);
    }

    /**
     * Recursive helper method to check if a value is contained within the tree.
     *
     * @param root  The root of the current subtree.
     * @param value The value to search for.
     * @return true if the value is found, false otherwise.
     */
    private boolean contains(SearchTreeNode<E> root, E value) {
        if (root == null) {
            return false;
        } else {
            int compare = value.compareTo(root.data);
            if (compare == 0) {
                return true;
            } else if (compare < 0) {
                return contains(root.left, value);
            } else {
                return contains(root.right, value);
            }
        }
    }

    /**
     * Removes all elements from the tree, resetting it to an empty state.
     */
    public void clear() {
        overallRoot = null;
    }

    /**
     * Inner class representing a node in the SearchTree.
     * Each node contains data and references to its left and right children.
     *
     * @param <E> The type of data stored in the node.
     */
    private static class SearchTreeNode<E> {
        public E data; // Data stored in this node
        public SearchTreeNode<E> left; // Left subtree
        public SearchTreeNode<E> right; // Right subtree

        /**
         * Constructs a leaf node with the given data.
         *
         * @param data The data to be stored in this node.
         */
        public SearchTreeNode(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
